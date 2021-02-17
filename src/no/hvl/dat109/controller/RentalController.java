package no.hvl.dat109.controller;

import java.util.Scanner;

/**
 * Interface for rental controller.
 * 
 * @author
 */
public interface RentalController {

    /**
     * Makes a reservation and saves customer info.
     */
    public void bookVehicle(Scanner sc);

    /**
     * Creates a Rental-object with credit card and vehicle registration number.
     */
    public void rentVehicle(Scanner sc);

    /**
     * Returns a vehicle and bills the customer based on current vehicle mileage.
     */
    public void returnVehicle(Scanner sc);
}
