package no.hvl.dat109.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import no.hvl.dat109.constants.Constants;
import no.hvl.dat109.models.Company;
import no.hvl.dat109.models.Customer;
import no.hvl.dat109.models.Office;
import no.hvl.dat109.models.Rental;
import no.hvl.dat109.models.Reservation;
import no.hvl.dat109.models.Return;
import no.hvl.dat109.models.Vehicle;
import no.hvl.dat109.utils.Address;
import no.hvl.dat109.utils.CreditCard;
import no.hvl.dat109.utils.Dummy;

public class RentalControllerImpl implements RentalController {

    private Company company;

    public RentalControllerImpl(Company company) {
        this.company = company;
    }

    public RentalControllerImpl() {
        this(null);
    }

    @Override
    public void bookVehicle() {
        DateTimeFormatter dtf;
        List<Office> offices = Dummy.dummyOffices();
        LocalDate date;
        LocalTime time;
        Scanner sc = new Scanner(System.in);

        System.out.println("Rental office:");
        Office returnOffice = offices.get(sc.nextInt());
        sc.nextLine();

        System.out.println("Return office:");
        Office rentalOffice = offices.get(sc.nextInt());
        sc.nextLine();

        try {
            System.out.println("Date: (dd/MM/yyyy)");
            String dateString = sc.nextLine();
            dtf = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
            date = LocalDate.parse(dateString, dtf);
        } catch (Exception e) {
            System.out.println("Please input a properly formatted date");
            sc.close();
            return;
        }

        try {
            System.out.println("Time: (HH:mm)");
            String timeString = sc.nextLine();
            dtf = DateTimeFormatter.ofPattern(Constants.TIME_FORMAT);
            time = LocalTime.parse(timeString, dtf);
        } catch (Exception e) {
            System.out.println("Please input a properly formatted time");
            sc.close();
            return;
        }

        System.out.println("For how many consecutive days would you like to rent the vehicle:");
        int days = sc.nextInt();
        sc.nextLine();

        List<Vehicle> vehicles = rentalOffice.getAllVehicles();
        // TODO: Change to Group stream
        List<Vehicle> availableVehicles = vehicles.stream().filter(v -> v.isAvailable()).collect(Collectors.toList());

        System.out.println("Available vehicles:");
        availableVehicles.stream().forEach(v -> v.toString());

        // TODO: Select vehicle based on Group
        System.out.println("Registration number:");
        String regnr = sc.nextLine().toLowerCase();

        Vehicle vehicle = availableVehicles.stream().filter(v -> v.getRegnr().equals(regnr)).findAny().orElse(null);

        if (vehicle == null) {
            System.out.printf("Vehicle with registration number %s doesn't exist.\n", regnr);
            sc.close();
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

        sc.close();
    }

    @Override
    public void rentVehicle() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Phone number:");
        int phonenr = sc.nextInt();
        sc.nextLine();

        List<Reservation> allReservations = company.getReservations();

        Reservation reservation = allReservations.stream().filter(r -> phonenr == r.getCustomer().getPhonenr())
                .findAny().orElse(null);

        if (reservation == null) {
            System.out.println("No reservations with that phone number.");
            sc.close();
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

        sc.close();
    }

    @Override
    public void returnVehicle() {
        Scanner sc = new Scanner(System.in);
        LocalDate currentDate = LocalDate.now();

        System.out.println("Phone number:");
        int phonenr = sc.nextInt();
        sc.nextLine();

        List<Reservation> allReservations = company.getReservations();

        Reservation reservation = allReservations.stream().filter(r -> phonenr == r.getCustomer().getPhonenr())
                .findAny().orElse(null);

        if (reservation == null) {
            System.out.println("No reservation with that phone number.");
            sc.close();
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

        System.out.println("Receit sent.");
        CreditCard creditCard = reservation.getCustomer().getCreditCard();

        allReservations.remove(reservation);

        Return returnVehicle = new Return(creditCard, currentDate, vehicle.getRegnr(), mileage);
        List<Return> returnedVehicles = company.getReturnedCars();
        returnedVehicles.add(returnVehicle);

        sc.close();
    }
}
