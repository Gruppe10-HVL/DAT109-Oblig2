package no.hvl.dat109.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import no.hvl.dat109.models.Company;
import no.hvl.dat109.models.Office;
import no.hvl.dat109.models.Reservation;

public class RentalController {
    
    public static void rental(Company company) {
        Scanner sc = new Scanner(System.in);
    
        LocalDateTime currentDate = LocalDateTime.now();

        System.out.println("");

        List<Reservation> allReservations = company.getReservations();
    }
}
