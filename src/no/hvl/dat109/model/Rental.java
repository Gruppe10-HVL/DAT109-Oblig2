package no.hvl.dat109.model;

import java.time.LocalDate;

import no.hvl.dat109.util.CreditCard;

/**
 * Represents a rental of a vehicle.
 * @author 
 */
public class Rental {

    private CreditCard creditCard;
    private Vehicle vehicle;
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
    public Rental(CreditCard creditCard, Vehicle vehicle, int startMileage, LocalDate rentalDate, LocalDate returnDate) {
        this.creditCard = creditCard;
        this.vehicle = vehicle;
        this.startMileage = startMileage;
        this.endMileage = startMileage; // initialized to startMileage, changed on return
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.returned = false; // Initialized to false, changed on return
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setvehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
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
