package no.hvl.dat109.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import no.hvl.dat109.constants.Constants;
import no.hvl.dat109.utils.Address;
import no.hvl.dat109.models.Company;
import no.hvl.dat109.models.Customer;
import no.hvl.dat109.models.Office;
import no.hvl.dat109.models.Reservation;
import no.hvl.dat109.models.Vehicle;
import no.hvl.dat109.utils.Group;
import no.hvl.dat109.utils.Dummy;

public class ReservationController {

    public static boolean bookVehicle(Company company) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.BASIC_ISO_DATE;

        System.out.println("Rental office:");
        String rentalOfficeString = sc.nextLine();

        System.out.println("Return office:");
        String returnOfficeString = sc.nextLine();

        System.out.println("Date: (dd/MM/yyyy)");
        String dateString = sc.nextLine();

        dtf = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
        LocalDate date = LocalDate.parse(dateString, dtf);

        System.out.println("Time: (HH:mm)");
        String timeString = sc.nextLine();

        dtf = DateTimeFormatter.ofPattern(Constants.TIME_FORMAT);
        LocalTime time = LocalTime.parse(timeString, dtf);

        System.out.println("Rental days:");
        int days = sc.nextInt();
        sc.nextLine();

        Map<String, Vehicle> dummyVehicles = Dummy.dummyVehicleList();
        Office rentalOffice2 = new Office(3, new Address("", 0, ""), 3, dummyVehicles);

        Office rentalOffice = new Office(1, new Address("", 0, ""), 1); // TODO: stream company office list
        Office returnOffice = new Office(2, new Address("", 0, ""), 2); // TODO: stream company office list

        List<Vehicle> vehicles = rentalOffice2.getAllVehicles();

        // TODO: Change to Group stream
        List<Vehicle> availableVehicles = vehicles.stream().filter(v -> v.isAvailable() == true)
                .collect(Collectors.toList());

        System.out.println("Available vehicles:");
        availableVehicles.stream().forEach(System.out::println); // TODO: Change to toString

        // TODO: Select vehicle based on Group
        System.out.println("Registration number:");
        String regnr = sc.nextLine().toLowerCase();

        Vehicle vehicle = availableVehicles.stream().filter(v -> v.getRegnr().equals(regnr)).findAny().orElse(null);

        if (vehicle == null) {
            System.out.printf("Vehicle with registration number %s doesn't exist.\n", regnr);
            sc.close();
            return false;
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
        return true;
    }
}
