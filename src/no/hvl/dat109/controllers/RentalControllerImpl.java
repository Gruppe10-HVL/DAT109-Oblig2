package no.hvl.dat109.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import no.hvl.dat109.models.Company;
import no.hvl.dat109.models.Rental;
import no.hvl.dat109.models.Reservation;
import no.hvl.dat109.utils.CreditCard;

public class RentalControllerImpl {

    public RentalControllerImpl() {
        
    }

    public static boolean rental(Company company) {
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
            return false;
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
        return true;

    }
}
