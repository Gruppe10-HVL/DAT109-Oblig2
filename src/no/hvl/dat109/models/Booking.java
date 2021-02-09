package no.hvl.dat109.models;

import java.time.LocalDateTime;

public abstract class Booking {
    
    private RentalOffice office;
    private int regnr;
    private Customer customer;
    private LocalDateTime fromDate, toDate;

    public Booking(RentalOffice office, int regnr, Customer customer, LocalDateTime fromDate, LocalDateTime toDate) {
        this.office = office;
        this.regnr = regnr;
        this.customer = customer;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public RentalOffice getOffice() {
        return office;
    }

    public void setOffice(RentalOffice office) {
        this.office = office;
    }

    public int getRegnr() {
        return regnr;
    }

    public void setRegnr(int regnr) {
        this.regnr = regnr;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }


}   
