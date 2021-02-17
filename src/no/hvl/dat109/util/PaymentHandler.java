package no.hvl.dat109.util;

import java.time.Period;

import no.hvl.dat109.model.Rental;

import no.hvl.dat109.model.Vehicle;

public class PaymentHandler {

    public static int totalPrice(Vehicle vehicle, Rental rental) {
        int dailyPrice = vehicle.getGroup().getPrice();
        Period p = Period.between(rental.getRentalDate(), rental.getReturnDate());
        int days = p.getDays();
        return dailyPrice*days;
    }

}
