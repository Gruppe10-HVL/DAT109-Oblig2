package no.hvl.dat109.model;

import no.hvl.dat109.util.Group;

/**
 * Represents a vehicle.
 * @author
 */
public class Vehicle {

	private int dailyPrice;
	private String regnr, make, model;
	private Group group;
	private int mileage;
	private boolean available;

	/**
	 * Creates a new vehicle with mileage;
	 * @param regnr Vehicle registration number
	 * @param make Make of vehicle
	 * @param model Model of vehicle
	 * @param group Vehicle price group
	 * @param mileage Current vehicle mileage
	 */
	public Vehicle(String regnr, String make, String model, Group group, int mileage) {
		this.regnr = regnr;
		this.make = make;
		this.model = model;
		this.group = group;
		this.available = true;
		this.mileage = mileage;
		this.dailyPrice = group.getPrice();
	}

	/**
	 * Creates a new vehicle with no mileage.
	 * @param regnr Vehicle registration number
	 * @param make Make of vehicle
	 * @param model Model of vehicle
	 * @param group Vehicle price group
	 */
	public Vehicle(String regnr, String make, String model, Group group) {
		this(regnr, make, model, group, 0);
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

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "\nMake:" + make + "\nModel:" + model + "\nDaily Price:" + dailyPrice + "\n Vehicle Group:" + group
				+ "\nMileage=" + mileage + "\nRegistration Number:" + regnr + "\n\n";
	}

}
