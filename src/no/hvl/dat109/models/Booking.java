package no.hvl.dat109.models;

import java.time.LocalDate;

/**
 * 
 * Might drop class.
 * 
 */
public abstract class Booking {

    private Office office;
    private int id, regnr;
    private Customer customer;
    private LocalDate fromDate, toDate;

    /**
     * 
     * @param id
     * @param office
     * @param regnr
     * @param customer
     * @param fromDate
     * @param toDate
     */
    public Booking(int id, Office office, int regnr, Customer customer, LocalDate fromDate, LocalDate toDate) {
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

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

}
