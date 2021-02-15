package no.hvl.dat109.models;

import java.util.ArrayList;

import no.hvl.dat109.utils.Group;

public class Vehicle {

	private int dailyPrice;
	private String regnr, make, model;
	private Group group;
	private double mileage;
	private boolean available;
	private ArrayList<Booking> bookings;

	public Vehicle(String regnr, String make, String model, Group group, double mileage) {
		this.regnr = regnr;
		this.make = make;
		this.model = model;
		this.group = group;
		this.available = true;
		this.mileage = mileage;
		this.dailyPrice = group.getPrice();
		bookings = new ArrayList<Booking>();
	}

	public Vehicle(String regnr, String make, String model, Group group) {
		this(regnr, make, model, group, 0.0);
	}

	public Vehicle(boolean t) {
		this.regnr = "12345";
		this.make = "BMW";
		this.model = "320d";
		this.group = group.SMALL;
		this.mileage = 231923.21;
		this.dailyPrice = group.getPrice();
		bookings = new ArrayList<Booking>();
	}

	public String getRegnr() {
		return regnr;
	}

	public void setRegnr(String regnr) {
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

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public ArrayList<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "Daily Price:" + dailyPrice + "\n Vehicle Group=:" + group + "\nMake:" + make + "\nModel:" + model
				+ "\nMileage=" + mileage + "\nRegistration Number:" + regnr;
	}

}
