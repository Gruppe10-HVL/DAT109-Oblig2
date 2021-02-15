package no.hvl.dat109.models;

import java.util.ArrayList;
import java.util.List;

public class Company {
    
    private String name, phonenr;
    private Address address;
    private List<Reservation> reservations;
    private List<Office> offices;
    private List<Rental> rentals;
    private List<Return> returns;

    public Company(String name, Address address, String phonenr) {
        this.name = name;
        this.address = address;
        this.phonenr = phonenr;
        this.reservations = new ArrayList<Reservation>();
        this.offices = new ArrayList<Office>();
        this.rentals = new ArrayList<Rental>();
        this.returns = new ArrayList<Return>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenr() {
        return phonenr;
    }

    public void setPhonenr(String phonenr) {
        this.phonenr = phonenr;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
    
    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Office> getOffices() {
        return offices;
    }
    
    public List<Rental> getRentals() {
        return rentals;
    }

    public List<Return> getReturnedCars() {
        return returns;
    }

    /**
     * 
     * @param reservation
     */
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void addRentedVehicle(Rental rental) {
        rentals.add(rental);
    }

    public void addOffice(Office office) {
        offices.add(office);
    }

    public void addReturnedVehicle(Return returnVehicle) {
        returns.add(returnVehicle);
    }


}
