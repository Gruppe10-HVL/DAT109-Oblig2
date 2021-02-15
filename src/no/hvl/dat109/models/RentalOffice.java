package no.hvl.dat109.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import no.hvl.dat109.utils.Group;

public class RentalOffice {
    
    private int officenr, phonenr;
    private String address; // Change to Address-object?
    private Map<Integer, Vehicle> vehicles;
    private Map<Integer, ArrayList<Booking>> bookings;

    public RentalOffice(int officenr, String address, int phonenr) {
        this.officenr = officenr;
        this.address = address;
        this.phonenr = phonenr;
        this.vehicles = new HashMap<Integer, Vehicle>();
        this.bookings = new HashMap<Integer, ArrayList<Booking>>();
    }

    public Vehicle getVehicle(int regnr) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<Integer, Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Map<Integer, Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Map<Integer, ArrayList<Booking>> getBookings() {
        return bookings;
    }

    public void setBookings(Map<Integer, ArrayList<Booking>> bookings) {
        this.bookings = bookings;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.put(vehicle.getRegnr(), vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle.getRegnr());
    }

    public ArrayList<Vehicle> getAllVehiclesByGroup(Group group) {
        return vehicles.values()
            .stream().filter(x -> x.getGroup().compareTo(group) == 0)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<Vehicle>(vehicles.values());
    }
}
