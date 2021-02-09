package no.hvl.dat109.models;

import java.time.LocalDateTime;

public class Reservation extends Booking {

    public Reservation(RentalOffice office, int regnr, Customer customer, LocalDateTime fromDate,
            LocalDateTime toDate) {
        super(office, regnr, customer, fromDate, toDate);
    }
    
    
}
