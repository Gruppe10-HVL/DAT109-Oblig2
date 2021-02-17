package no.hvl.dat109.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import no.hvl.dat109.constants.Constants;
import no.hvl.dat109.models.Company;
import no.hvl.dat109.models.Customer;
import no.hvl.dat109.models.Office;
import no.hvl.dat109.models.Rental;
import no.hvl.dat109.models.Reservation;
import no.hvl.dat109.models.Vehicle;
import no.hvl.dat109.utils.Address;
import no.hvl.dat109.utils.CreditCard;
import no.hvl.dat109.utils.Group;

public class RentalControllerImpl implements RentalController {

    private Company company;

    /**
     * 
     * @param company
     */
    public RentalControllerImpl(Company company) {
        this.company = company;
    }

    /**
     * 
     */
    public RentalControllerImpl() {
        this(null);
    }

    @Override
    public void search() {

    }

    @Override
    public void searchByGroup() {

    }

    @Override
    public void bookVehicle() {
        DateTimeFormatter dtf;
        List<Office> offices = company.getOffices();
        LocalDate date;
        LocalTime time;
        Scanner sc = new Scanner(System.in); // cant close scanner in method, will crash client
        System.out.println("Here is a list of our available offices: ");
        offices.forEach(System.out::println);
        System.out.println("Rental office:");
        Office returnOffice = offices.get(sc.nextInt() - 1);
        sc.nextLine();

        System.out.println("Return office:");
        Office rentalOffice = offices.get(sc.nextInt() - 1);
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

        System.out.println("Please select a vehicle group: (Write the full name of your preferred group)");
        List<Group> groupList = new ArrayList<>(Arrays.asList(Group.values()));
        groupList.forEach(System.out::println);
        Group chosenGroup = Group.valueOf(sc.nextLine().toUpperCase());
        List<Vehicle> vehicles = rentalOffice.getAllVehicles();
        List<Vehicle> availableVehicles = vehicles.stream()
                .filter(v -> v.getGroup().equals(chosenGroup) && v.isAvailable()).collect(Collectors.toList());

        System.out.println("Available vehicles:");
        availableVehicles.stream().forEach(System.out::println);

        // TODO: Select vehicle based on Group
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
        int phone = sc.nextInt();
        sc.nextLine();

        System.out.println("Street-address:");
        String street = sc.nextLine();

        System.out.println("Postal code:");
        int postalCode = sc.nextInt();
        sc.nextLine();

        System.out.println("Postal address:");
        String postalAddress = sc.nextLine();

        Customer customer = new Customer(fName, lName, new Address(street, postalCode, postalAddress), phone);
        Reservation reservation = new Reservation(vehicle, date, time, days, rentalOffice, returnOffice, customer);

        System.out.println("Booking complete");

        company.addReservation(reservation);

    }

    @Override
    public void rentVehicle() {
        Scanner sc = new Scanner(System.in); // cant close scanner in method, will crash client

        System.out.println("Phone number:");
        int phonenr = sc.nextInt();
        sc.nextLine();

        List<Reservation> allReservations = company.getReservations();

        Reservation reservation = allReservations.stream().filter(r -> phonenr == r.getCustomer().getPhonenr())
                .findAny().orElse(null);

        if (reservation == null) {
            System.out.println("No reservations with that phone number.");

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

        String regnr = reservation.getVehicle().getRegnr();
        int mileage = reservation.getVehicle().getMileage();

        Rental rental = new Rental(creditCard, regnr, mileage, rentalDate, returnDate);
        company.addRentedVehicle(rental);
        System.out.println("Rental complete!");

    }

    @Override
    public void returnVehicle() {
        Scanner sc = new Scanner(System.in); // cant close scanner in method, will crash client
        LocalDate currentDate = LocalDate.now();

        System.out.println("Phone number:");
        int phonenr = sc.nextInt();
        sc.nextLine();

        List<Reservation> allReservations = company.getReservations();

        Reservation reservation = allReservations.stream().filter(r -> phonenr == r.getCustomer().getPhonenr())
                .findAny().orElse(null);

        if (reservation == null) {
            System.out.println("No reservation with that phone number.");

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

        System.out.println("Receipt sent.");
        CreditCard creditCard = reservation.getCustomer().getCreditCard();
        Rental rental = company.getRentals().stream().filter(r -> r.getCreditCard() == creditCard).findAny()
                .orElse(null);
        if (rental == null) {
            System.out.println("An error has occurred, please call customer service.");
        } else {
            rental.setReturned(true);
            rental.setEndMileage(mileage);
            allReservations.remove(reservation);
        }
    }
}
