package no.hvl.dat109.models;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import no.hvl.dat109.constants.Constants;

public class Vehicle {
    
    private int regnr, dailyPrice;
    private String make, model;
    private char group;
    private double mileage;
    private Queue<Booking> bookings;

    public Vehicle (int regnr, String make, String model, char group, double mileage) {
        this.regnr = regnr;
        this.make = make;
        this.model = model;
        this.group = group;
        this.mileage = mileage;
        this.dailyPrice = Constants.getPrice(group);
        bookings = new LinkedBlockingQueue<Booking>();
    }

    public int getRegnr() {
        return regnr;
    }

    public void setRegnr(int regnr) {
        this.regnr = regnr;
    }

    public int getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(int dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public char getGroup() {
        return group;
    }

    public void setGroup(char group) {
        this.group = group;
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public Queue<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Queue<Booking> bookings) {
        this.bookings = bookings;
    }

    
}
