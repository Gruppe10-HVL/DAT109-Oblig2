package no.hvl.dat109.models;

import java.time.LocalDate;

import no.hvl.dat109.utils.CreditCard;

/**
 * Represents a rental of a vehicle.
 * @author 
 */
public class Rental {

    private CreditCard creditCard;
    private String regnr;
    private int startMileage, endMileage;
    private LocalDate rentalDate, returnDate;
    private boolean returned;

    /**
     * Creates a new rental.
     * @param creditCard Customer credit card
     * @param regnr Vehicle registration number
     * @param startMileage Vehicle start mileage
     * @param rentalDate Pick-up date of rental
     * @param returnDate Return date of rental
     * @param returned If vehicle is returned or not
     */
    public Rental(CreditCard creditCard, String regnr, int startMileage, LocalDate rentalDate, LocalDate returnDate,
            boolean returned) {
        this.creditCard = creditCard;
        this.regnr = regnr;
        this.startMileage = startMileage;
        this.endMileage = startMileage; // initialized to startMileage, changed on return
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.returned = false; // Initialized to false, changed on return
    }

    public Rental(CreditCard creditCard2, String regnr2, int mileage, LocalDate rentalDate2, LocalDate returnDate2) {
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public String getRegnr() {
        return regnr;
    }

    public void setRegnr(String regnr) {
        this.regnr = regnr;
    }

    public int getStartMileage() {
        return startMileage;
    }

    public int getEndMileage() {
        return endMileage;
    }

    public void setEndMileage(int endMileage) {
        this.endMileage = endMileage;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

}
