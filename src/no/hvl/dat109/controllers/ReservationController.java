package no.hvl.dat109.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import no.hvl.dat109.constants.Constants;
import no.hvl.dat109.models.Address;
import no.hvl.dat109.models.Customer;
import no.hvl.dat109.models.Office;
import no.hvl.dat109.models.Reservation;
import no.hvl.dat109.models.Vehicle;

public class ReservationController {

    public static void bookCar() {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;
        
        System.out.println("Rental office:");
        String rentalOfficeString = sc.nextLine();

        System.out.println("Return office:");
        String returnOfficeString = sc.nextLine();

        System.out.println("Date: (dd/MM/yyyy)");
        String dateString = sc.nextLine();

        dtf = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
        LocalDateTime date = LocalDateTime.parse(dateString, dtf);

        System.out.println("Time: (HH:mm:ss)");
        String timeString = sc.nextLine();

        dtf = DateTimeFormatter.ofPattern(Constants.TIME_FORMAT);
        LocalDateTime time = LocalDateTime.parse(timeString, dtf);

        System.out.println("Rental days:");
        int days = sc.nextInt();
        sc.nextLine();

        Office rentalOffice = new Office(1, new Address("", 0, ""), 1); // TODO: stream company office list
        Office returnOffice = new Office(2, new Address("", 0, ""), 2); // TODO: stream company office list

        List<Vehicle> vehicles = rentalOffice.getAllVehicles();

        // TODO: Change to Group stream
        List<Vehicle> availableVehicles = vehicles.stream()
                                    .filter(v -> v.isAvailable() == true)
                                    .collect(Collectors.toList());
        
        System.out.println("Available vehicles:");
        availableVehicles.stream().forEach(System.out::println); // TODO: Change to toString

        // TODO: Select vehicle based on Group
        System.out.println("Registration number:");
        String regnr = sc.nextLine();

        Vehicle vehicle = availableVehicles.stream()
                    .filter(v -> v.getRegnr().equals(regnr))
                    .findAny()
                    .orElse(null);

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

        System.out.println("Booking complete");

        Customer customer = new Customer(fName, lName, new Address(street, postalCode, postalAddress), phone);
        Reservation reservation = new Reservation(vehicle, date, time, days, rentalOffice, returnOffice, customer);
        // TODO Add reservation to rental company

        // TODO return to client
    }
}
