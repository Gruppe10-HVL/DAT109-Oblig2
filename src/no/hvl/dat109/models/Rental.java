package no.hvl.dat109.models;

import java.time.LocalDate;

import no.hvl.dat109.utils.CreditCard;

public class Rental {

    private CreditCard creditCard;
    private String regnr;
    private int mileage;
    private LocalDate rentalDate, returnDate;

    public Rental(CreditCard creditCard, String regnr, int mileage, LocalDate rentalDate, LocalDate returnDate) {
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
