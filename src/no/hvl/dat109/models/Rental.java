package no.hvl.dat109.models;

import java.time.LocalDateTime;

public class Rental extends Booking {

    private int creditCardNr;
    private double mileage;


    public Rental(int id, Office office, int regnr, Customer customer, LocalDateTime fromDate, LocalDateTime toDate, int creditCardNr, double mileage) {
        super(id, office, regnr, customer, fromDate, toDate);
        this.creditCardNr = creditCardNr;
        this.mileage = mileage;
    }

    public int getCreditCardNr() {
        return creditCardNr;
    }

    public void setCreditCardNr(int creditCardNr) {
        this.creditCardNr = creditCardNr;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }
    
}
