package no.hvl.dat109.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import no.hvl.dat109.models.Company;
import no.hvl.dat109.models.Office;
import no.hvl.dat109.models.Reservation;
import no.hvl.dat109.models.Vehicle;

public class ReturnController {
    
    public static void returnVehicle(Company company) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Phone number:");
        int phonenr = sc.nextInt();
        sc.nextLine();

        List<Reservation> allReservations = company.getReservations();

        Reservation reservation = allReservations.stream()
                            .filter(r -> phonenr == r.getCustomer().getPhonenr())
                            .findAny()
                            .orElse(null);

        if (reservation == null) {
            System.out.println("No reservation with that phone number.");
            sc.close();
            return;
        }

        LocalDateTime currentDate = LocalDateTime.now();

        System.out.println("Enter current mileage:");
        int mileage = sc.nextInt();
        sc.nextLine();

        Vehicle vehicle = reservation.getVehicle();
        vehicle.setMileage(mileage);
        vehicle.setAvailable(true);

        Office returnOffice = reservation.getReturnOffice();
        returnOffice.addVehicle(vehicle);

        System.out.println("Receit sent.");
    }
}
