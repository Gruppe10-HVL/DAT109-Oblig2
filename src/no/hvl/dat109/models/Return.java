package no.hvl.dat109.models;

import java.time.LocalDate;

import no.hvl.dat109.utils.CreditCard;

public class Return {
    private CreditCard creditCard;
    private LocalDate currentDate;
    private String regnr;
    private int mileage;

    public Return(CreditCard creditCard, LocalDate currentDate, String regnr, int mileage) {
        this.creditCard = creditCard;
        this.currentDate = currentDate;
        this.regnr = regnr;
        this.mileage = mileage;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public String getRegnr() {
        return regnr;
    }

    public void setRegnr(String regnr) {
        this.regnr = regnr;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

}
