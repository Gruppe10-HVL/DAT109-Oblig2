package no.hvl.dat109.models;

import java.util.ArrayList;

import no.hvl.dat109.utils.Group;

public class Vehicle {
    
    private int regnr, dailyPrice;
    private String make, model;
    private Group group;
    private double mileage;
    private ArrayList<Booking> bookings;

    public Vehicle (int regnr, String make, String model, Group group, double mileage) {
        this.regnr = regnr;
        this.make = make;
        this.model = model;
        this.group = group;
        this.mileage = mileage;
        this.dailyPrice = group.getPrice();
        bookings = new ArrayList<Booking>();
    }

	public Vehicle(int regnr, String make, String model, Group g) {
		this(regnr, make, model, g, 0.0);
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

    @Override
	public String toString() {
		return "";
	}
}
