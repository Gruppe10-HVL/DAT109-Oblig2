package no.hvl.dat109.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import no.hvl.dat109.utils.Group;
import no.hvl.dat109.utils.Address;

public class Office {

    private int officenr, phonenr;
    private Address address;
    private Map<String, Vehicle> vehicles;
    private Map<Integer, ArrayList<Booking>> bookings;

    public Office(int officenr, Address address, int phonenr) {
        this.officenr = officenr;
        this.address = address;
        this.phonenr = phonenr;
        this.vehicles = new HashMap<String, Vehicle>();
        this.bookings = new HashMap<Integer, ArrayList<Booking>>();
    }

    public Office(int officenr, Address address, int phonenr, Map<String, Vehicle> vehicles) {
        this.officenr = officenr;
        this.address = address;
        this.phonenr = phonenr;
        this.vehicles = vehicles;
        this.bookings = new HashMap<Integer, ArrayList<Booking>>();
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

    public Reservation createReservation(Vehicle v, LocalDate fromDate, LocalTime fromTime, int days,
            Office rentalOffice, Office returnOffice, Customer customer) {
        return new Reservation(v, fromDate, fromTime, days, rentalOffice, returnOffice, customer);
    }

    public ArrayList<Vehicle> getAllVehiclesByGroup(Group group) {
        return vehicles.values().stream().filter(x -> x.getGroup().compareTo(group) == 0)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Vehicle> getAllVehicles() {
        return new ArrayList<Vehicle>(vehicles.values());
    }
}
