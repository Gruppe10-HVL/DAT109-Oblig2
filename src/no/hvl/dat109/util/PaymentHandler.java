package no.hvl.dat109.util;

import no.hvl.dat109.model.Reservation;
import no.hvl.dat109.model.Vehicle;

public class PaymentHandler {

    public static int totalPrice(Vehicle vehicle, Reservation reservation) {
        int dailyPrice = vehicle.getGroup().getPrice();
        int days = reservation.getDays();
        return dailyPrice * days;
    }

}
