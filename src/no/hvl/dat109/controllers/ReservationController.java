package no.hvl.dat109.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
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
        LocalDate date;
        LocalTime time;
        DateTimeFormatter dtf;
        List<Office> offices = Dummy.dummyOffices();
        Scanner sc = new Scanner(System.in);

        System.out.println("Rental office: You may choose between:\n 1. Bergen\n 2. Oslo\n 3. Trondheim\n 4. Molde");
        Office rentalOffice = offices.get(sc.nextInt());
        sc.nextLine();

        System.out.println("Return office: You may choose between:\n 1. Bergen\n 2. Oslo\n 3. Trondheim\n 4. Molde");
        Office returnOffice = offices.get(sc.nextInt());
        sc.nextLine();

        try {
            System.out.println("Date: (dd/MM/yyyy)");
            String dateString = sc.nextLine();

            dtf = DateTimeFormatter.ofPattern(Constants.DATE_FORMAT);
            date = LocalDate.parse(dateString, dtf);
        } catch (Exception e) {
            System.out.println("Please provide a valid date");
            sc.close();
            return false;
        }

        try {
            System.out.println("Time: (HH:mm)");
            String timeString = sc.nextLine();

            dtf = DateTimeFormatter.ofPattern(Constants.TIME_FORMAT);
            time = LocalTime.parse(timeString, dtf);
        } catch (Exception e) {
            System.out.println("Please provide a valid time");
            sc.close();
            return false;
        }

        System.out.println("For how many consecutive dates do you wish to rent the car?:");
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
