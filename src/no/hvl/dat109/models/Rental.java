package no.hvl.dat109.models;

import java.time.LocalDateTime;

import no.hvl.dat109.utils.CreditCard;

public class Rental {

    private CreditCard creditCard;
    private String regnr;
    private double mileage;
    private LocalDateTime rentalDate, returnDate;
    
    public Rental(CreditCard creditCard, String regnr, double mileage, LocalDateTime rentalDate, LocalDateTime returnDate) {
        this.creditCard = creditCard;
        this.regnr = regnr;
        this.mileage = mileage;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }
}
