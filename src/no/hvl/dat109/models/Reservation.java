package no.hvl.dat109.models;

import java.time.LocalDate;
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

    public void book(Vehicle vehicle) {
        LocalDateTime currentDate = LocalDateTime.now();
        LocalDateTime endDate = fromDate.plusDays(days);

        while (currentDate.isAfter(fromDate) && currentDate.isBefore(endDate)) {
            vehicle.setAvailable(false);
        }
    }
}
