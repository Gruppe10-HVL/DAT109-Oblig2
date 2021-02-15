package no.hvl.dat109.models;

import java.time.LocalDateTime;

public class Reservation {

    private Vehicle vehicle;
    private LocalDateTime fromDate, fromTime;
    private int days;
    private Office rentalOffice, returnOffice;
    private Customer customer;

    public Reservation(Vehicle vehicle, LocalDateTime fromDate, LocalDateTime fromTime, int days, Office rentalOffice, Office returnOffice, Customer customer) {
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

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(LocalDateTime fromTime) {
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
    
    public void book(Vehicle vehicle) {
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime endDate = fromDate.plusDays(days);

        if (currentDate.isAfter(fromDate) && currentDate.isBefore(endDate)) {
            vehicle.setAvailable(false);
        }
    }
}
