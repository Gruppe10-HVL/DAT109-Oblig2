package no.hvl.dat109.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import no.hvl.dat109.utils.Group;
import no.hvl.dat109.utils.Address;

/**
 * Represents an office.
 * @author 
 */
public class Office {

    private int officenr, phonenr;
    private Address address;
    private Map<String, Vehicle> vehicles;

    /**
     * Creates a new rental office without vehicles.
     * @param officenr
     * @param address
     * @param phonenr
     */
    public Office(int officenr, Address address, int phonenr) {
        this.officenr = officenr;
        this.address = address;
        this.phonenr = phonenr;
        this.vehicles = new HashMap<String, Vehicle>();
    }

    /**
     * Creates a new rental office with one or more vehicles.
     * @param officenr
     * @param address
     * @param phonenr
     * @param vehicles
     */
    public Office(int officenr, Address address, int phonenr, Map<String, Vehicle> vehicles) {
        this.officenr = officenr;
        this.address = address;
        this.phonenr = phonenr;
        this.vehicles = vehicles;
    }

    public Vehicle getVehicle(String regnr) {
        return vehicles.get(regnr);
    }

    public int getOfficenr() {
        return officenr;
    }

    public void setOfficenr(int officenr) {
        this.officenr = officenr;
    }

    public int getPhonenr() {
        return phonenr;
    }

    public void setPhonenr(int phonenr) {
        this.phonenr = phonenr;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Map<String, Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Map<String, Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     * Add a vehicle to the office.
     * @param vehicle The vehicle to add.
     */
    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getRegnr(), vehicle);
    }

    /**
     * Remove a vehicle from the office.
     * @param vehicle The vehicle to be removed.
     */
    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle.getRegnr());
    }

    /**
     * Returns a list of all vehicles of a specified group at
     * the office.
     * @param group The specified group.
     * @return A list of vehicles.
     */
    public ArrayList<Vehicle> getAllVehiclesByGroup(Group group) {
        return vehicles.values().stream().filter(x -> x.getGroup().compareTo(group) == 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    /**
     * Returns a list of all vehicles at the office.
     * @return A list of vehicles.
     */
    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<Vehicle>(vehicles.values());
    }

    @Override
    public String toString() {
        return "\nOffice ID: " + officenr + address + "\nPhone number: " + phonenr + "\n";
    }
}
