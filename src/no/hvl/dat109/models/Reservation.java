package no.hvl.dat109.models;

import java.time.LocalDateTime;

public class Reservation extends Booking {

    public Reservation(int id, RentalOffice office, int regnr, Customer customer, LocalDateTime fromDate,
            LocalDateTime toDate) {
        super(id, office, regnr, customer, fromDate, toDate);
    }
    
    
}
