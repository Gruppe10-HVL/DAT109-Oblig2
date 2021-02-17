package no.hvl.dat109.models;

import java.util.ArrayList;
import java.util.List;
import no.hvl.dat109.utils.Address;

public class Company {

    private String name;
    private int phonenr;
    private Address address;
    private List<Reservation> reservations;
    private List<Office> offices;
    private List<Rental> rentals;
    private List<Return> returns;

    /**
     * 
     * @param name
     * @param address
     * @param phonenr
     */
    public Company(String name, Address address, int phonenr) {
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

    /**
     * 
     * @param rental
     */
    public void addRentedVehicle(Rental rental) {
        rentals.add(rental);
    }

    /**
     * 
     * @param office
     */
    public void addOffice(Office office) {
        offices.add(office);
    }

    /**
     * 
     * @param returnVehicle
     */
    public void addReturnedVehicle(Return returnVehicle) {
        returns.add(returnVehicle);
    }

    @Override
    public String toString() {
        return "\n Name:" + name + "\nAddress:" + address + "\nPhone number:" + phonenr + "\n\n";
    }

}
