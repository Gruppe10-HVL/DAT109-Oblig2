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
import no.hvl.dat109.models.Address;
import no.hvl.dat109.models.Customer;
import no.hvl.dat109.models.Office;
import no.hvl.dat109.models.Reservation;
import no.hvl.dat109.models.Vehicle;
import no.hvl.dat109.utils.Group;

public class ReservationController {

    public static void bookVehicle() {
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

        // Remove vehicle lines.
        Map<String, Vehicle> dummyVehicles = new HashMap<>();
        dummyVehicles.put("st1", new Vehicle("st1", "BMW", "320d", Group.MEDIUM, 122000));
        dummyVehicles.put("st2", new Vehicle("st2", "Audi", "A2", Group.MEDIUM, 254000));
        dummyVehicles.put("st3", new Vehicle("st3", "Alfa Romeo", "Julia", Group.MEDIUM, 512000));
        dummyVehicles.put("st4", new Vehicle("st4", "Lancia", "Delta integrale", Group.MEDIUM, 612000));
        dummyVehicles.put("st5", new Vehicle("st5", "Peugot", "307", Group.MEDIUM, 32000));
        dummyVehicles.put("st6", new Vehicle("st6", "Seat", "fiesta", Group.MEDIUM, 41000));
        dummyVehicles.put("st7", new Vehicle("st7", "VW", "boble", Group.MEDIUM, 214200));
        dummyVehicles.put("st8", new Vehicle("st8", "Porsche", "Spyder", Group.MEDIUM, 1422000));
        dummyVehicles.put("st9", new Vehicle("st9", "Ferrarri", "LaFerrari", Group.MEDIUM, 214000));
        // Remove vehicle lines.
        Office rentalOffice2 = new Office(3, new Address("", 0, ""), 3, dummyVehicles);
        // Remove vehicle lines.

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
            try {
                System.out.printf("Vehicle with registration number %s doesn't exist.\n", regnr);
                sc.close();
                return false;
            } catch (Exception e) {
            }
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

        return true;
        // TODO Add reservation to rental company

        // TODO return to client
    }
}
