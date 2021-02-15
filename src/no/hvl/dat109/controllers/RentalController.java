package no.hvl.dat109.controllers;

public class RentalController {

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import no.hvl.dat109.models.Customer;
import no.hvl.dat109.models.RentalOffice;
import no.hvl.dat109.models.Reservation;
import no.hvl.dat109.models.Vehicle;
import no.hvl.dat109.utils.Group;

public class RentalController {

    private HashMap<Integer, Reservation> reservations;
    private Scanner sc;

    public RentalController() {
        this.reservations = new HashMap<Integer, Reservation>();
        this.sc = new Scanner(System.in);
    }

    public void addReservation(int id, Reservation reservation) {
        reservations.put(id, reservation);
    }

    public void removeReservation(int id) {
        reservations.remove(id);
    }

    public Group search(RentalOffice rentalOffice) {
        // Get dates as String inputs
        System.out.println("From date:");
        String fromTxt = sc.nextLine();

        System.out.println("To date:");
        String toTxt = sc.nextLine();

        sc.close();

        LocalDateTime from = LocalDateTime.parse(fromTxt);
        LocalDateTime to = LocalDateTime.parse(toTxt);

        Map<Group, ArrayList<Vehicle>> vehicles = new HashMap<Group, ArrayList<Vehicle>>();
        ArrayList<Integer> reservedVehicles = reservations.values().stream()
                .filter(v -> v.getFromDate().compareTo(from) >= 0 && v.getToDate().compareTo(to) <= 0)
                .map(v -> v.getRegnr()).collect(Collectors.toCollection(ArrayList::new));

        for (Group g : Group.values()) {
            ArrayList<Vehicle> vehicleGroup = rentalOffice.getAllVehiclesByGroup(g).stream()
                    .filter(v -> !reservedVehicles.contains(v.getRegnr()))
                    .collect(Collectors.toCollection(ArrayList::new));

            vehicles.put(g, vehicleGroup);
        }

        System.out.println("|------------------------------|");
        for (ArrayList<Vehicle> vs : vehicles.values()) {
            vs.stream().forEach(v -> System.out.println(v.toString()));
        }
        System.out.println("|------------------------------|");

        System.out.println();

        System.out.println("Choose a group:");
        Group chosenGroup = Group.valueOf(sc.nextLine());

        return chosenGroup;
    }

}
