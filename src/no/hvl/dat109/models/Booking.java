package no.hvl.dat109.models;

import java.time.LocalDateTime;

public abstract class Booking {
    
    private Office office;
    private int id, regnr;
    private Customer customer;
    private LocalDateTime fromDate, toDate;

    public Booking(int id, Office office, int regnr, Customer customer, LocalDateTime fromDate, LocalDateTime toDate) {
        this.id = id;
        this.office = office;
        this.regnr = regnr;
        this.customer = customer;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
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
