package no.hvl.dat109.models;

import java.time.LocalDate;
import java.time.LocalTime;

public class Reservation {

    private Vehicle vehicle;
    private LocalDate fromDate;
    LocalTime fromTime;
    private int days;
    private Office rentalOffice, returnOffice;
    private Customer customer;

    public Reservation(Vehicle vehicle, LocalDate fromDate, LocalTime fromTime, int days, Office rentalOffice,
            Office returnOffice, Customer customer) {
        this.vehicle = vehicle;
        this.fromDate = fromDate;
        this.fromTime = fromTime;
        this.days = days;
        this.rentalOffice = rentalOffice;
        this.returnOffice = returnOffice;
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalTime fromTime) {
        this.fromTime = fromTime;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public Office getRentalOffice() {
        return rentalOffice;
    }

    public void setRentalOffice(Office rentalOffice) {
        this.rentalOffice = rentalOffice;
    }

    public Office getReturnOffice() {
        return returnOffice;
    }

    public void setReturnOffice(Office returnOffice) {
        this.returnOffice = returnOffice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
