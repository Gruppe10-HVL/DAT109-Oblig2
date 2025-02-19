package no.hvl.dat109.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import no.hvl.dat109.model.Company;
import no.hvl.dat109.model.Customer;
import no.hvl.dat109.model.Office;
import no.hvl.dat109.model.Rental;
import no.hvl.dat109.model.Reservation;
import no.hvl.dat109.model.Vehicle;
import no.hvl.dat109.util.Address;
import no.hvl.dat109.util.Constants;
import no.hvl.dat109.util.CreditCard;
import no.hvl.dat109.util.Group;
import no.hvl.dat109.util.PaymentHandler;

/**
 * Represents a controller for reservations, rentals and returns of vehicles.
 * 
 * @author
 */
public class RentalControllerImpl implements RentalController {

    private Company company;

    /**
     * Creates a rental controller for a specified company.
     * 
     * @param company
     */
    public RentalControllerImpl(Company company) {
        this.company = company;
    }

    @Override
    public void bookVehicle(Scanner sc) {
        DateTimeFormatter dtf;
        List<Office> offices = company.getOffices();
        LocalDate date;
        LocalTime time;
        System.out.println("Here is a list of our available offices: ");
        offices.forEach(System.out::println);
        System.out.println("Rental office:");
        Office rentalOffice = offices.get(sc.nextInt() - 1);
        sc.nextLine();

        System.out.println("Return office:");
        Office returnOffice = offices.get(sc.nextInt() - 1);
        sc.nextLine();

        try {
            System.out.println("Date: (dd/MM/yyyy)");
            String dateString = sc.nextLine();
            dtf = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
            date = LocalDate.parse(dateString, dtf);
        } catch (Exception e) {
            System.out.println("Please input a properly formatted date");

            return;
        }

        try {
            System.out.println("Time: (HH:mm)");
            String timeString = sc.nextLine();
            dtf = DateTimeFormatter.ofPattern(Constants.TIME_FORMAT);
            time = LocalTime.parse(timeString, dtf);
        } catch (Exception e) {
            System.out.println("Please input a properly formatted time");

            return;
        }

        System.out.println("For how many consecutive days would you like to rent the vehicle:");
        int days = sc.nextInt();
        sc.nextLine();

        System.out.println("\nPlease select a vehicle group: (Write the full name of your preferred group)\n");
        List<Group> groupList = new ArrayList<>(Arrays.asList(Group.values()));
        groupList.forEach(v -> v.getPriceAndName());
        Group chosenGroup = Group.valueOf(sc.nextLine().toUpperCase());
        List<Vehicle> vehicles = rentalOffice.getAllVehicles();
        List<Vehicle> availableVehicles = vehicles.stream()
                .filter(v -> v.getGroup().equals(chosenGroup) && v.isAvailable()).collect(Collectors.toList());

        System.out.println("Available vehicles:");
        availableVehicles.stream().forEach(System.out::println);

        System.out.println("Registration number:");
        String regnr = sc.nextLine().toUpperCase();

        Vehicle vehicle = availableVehicles.stream().filter(v -> v.getRegnr().equals(regnr)).findAny().orElse(null);

        if (vehicle == null) {
            System.out.printf("Vehicle with registration number %s doesn't exist.\n", regnr);
            return;
        }

        System.out.println("Firstname:");
        String fName = sc.nextLine();

        System.out.println("Lastname:");
        String lName = sc.nextLine();

        System.out.println("Phonenr:");
        int phonenr = sc.nextInt();
        sc.nextLine();

        System.out.println("Street-address:");
        String street = sc.nextLine();

        System.out.println("Postal code:");
        int postalCode = sc.nextInt();
        sc.nextLine();

        System.out.println("Postal address:");
        String postalAddress = sc.nextLine();

        Customer customer;

        if (company.hasCustomer(phonenr)) {
            customer = company.getCustomers().get(phonenr);
        } else {
            customer = new Customer(fName, lName, new Address(street, postalCode, postalAddress), phonenr);
            company.addCustomer(customer);
        }
        
        Reservation reservation = new Reservation(vehicle, date, time, days, rentalOffice, returnOffice, customer);

        System.out.println("Booking complete");

        customer.addReservation(reservation);
    }

    @Override
    public void rentVehicle(Scanner sc) {

        System.out.println("Phone number:");
        int phonenr = sc.nextInt();
        sc.nextLine();

        Customer customer = company.getCustomers().get(phonenr);

        if (customer == null) {
            System.out.println("No customer with that phone number.");

            return;
        }

        Reservation reservation = customer.getReservations().stream().filter(r -> phonenr == r.getCustomer().getPhonenr())
                .findAny().orElse(null);

        if (reservation == null) {
            System.out.println("No reservations registered.");

            return;
        }

        LocalDate rentalDate = reservation.getFromDate();
        LocalDate returnDate = rentalDate.plusDays(reservation.getDays());

        System.out.println("Credit card number:");
        long creditCardNr = sc.nextLong();
        sc.nextLine();

        CreditCard creditCard = new CreditCard(creditCardNr);

        while (!creditCard.validate()) {
            System.out.println("Card number is invalid.");
            creditCardNr = sc.nextLong();
            sc.nextLine();

            creditCard.setCardNumber(creditCardNr);
        }

        Vehicle vehicle = reservation.getVehicle();
        int mileage = reservation.getVehicle().getMileage();

        Rental rental = new Rental(creditCard, vehicle, mileage, rentalDate, returnDate);
        reservation.getRentalOffice().removeVehicle(vehicle);
        customer.addRental(rental);
        System.out.println("Rental complete!");

    }

    @Override
    public void returnVehicle(Scanner sc) {

        System.out.println("Phone number:");
        int phonenr = sc.nextInt();
        sc.nextLine();

        Customer customer = company.getCustomers().get(phonenr);

        if (customer == null) {
            System.out.println("No customer with that phone number.");

            return;
        }

        Reservation reservation = customer.getReservations().stream().filter(r -> phonenr == r.getCustomer().getPhonenr())
                .findAny().orElse(null);

        if (reservation == null) {
            System.out.println("No rentals registered.");

            return;
        }

        System.out.println("Enter current mileage:");
        int mileage = sc.nextInt();
        sc.nextLine();

        Vehicle vehicle = reservation.getVehicle();
        vehicle.setMileage(mileage);
        vehicle.setAvailable(true);

        Office returnOffice = reservation.getReturnOffice();
        returnOffice.addVehicle(vehicle);

        CreditCard creditCard = reservation.getCustomer().getCreditCard();
        Rental rental = customer.getRentals().stream().filter(r -> r.getCreditCard() == creditCard).findAny()
                .orElse(null);
        int totalPrice = PaymentHandler.totalPrice(vehicle, reservation);

        /*
         * 
         * It was not mentioned in the assignment, but now that we have a customers
         * credit card info and the total price, we may bill him. i.e:
         * makePayment(creditCard, totalPrice);
         */

        if (rental == null) {
            System.out.println("An error has occurred, please call customer service.");
        } else {
            rental.setReturned(true);
            rental.setEndMileage(mileage);
            customer.removeReservation(reservation);
            System.out.println("Receipt sent. Total price will be: " + totalPrice + "kr.");
        }
    }
}
