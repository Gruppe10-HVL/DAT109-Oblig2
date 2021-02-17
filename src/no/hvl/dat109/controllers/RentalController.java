package no.hvl.dat109.controllers;

public interface RentalController {
    
    /**
     * 
     */
    public void search();

    /**
     * 
     */
    public void searchByGroup(); 
    
    /**
     * Makes a reservation and saves customer info.
     */
    public void bookVehicle();

    /**
     * Creates a Rental-objekt with credit card and 
     * vehicle registration number.
     */
    public void rentVehicle();

    /**
     * Returns a vehicle and bills the customer based
     * on current vehicle mileage.
     */
    public void returnVehicle();
}
