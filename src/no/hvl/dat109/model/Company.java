package no.hvl.dat109.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hvl.dat109.util.Address;

public class Company {

    private String name;
    private int phonenr;
    private Address address;
    private List<Reservation> reservations;
    private List<Office> offices;
    private List<Rental> rentals;
    private Map<Integer, Customer> customers;

    /**
     * Creates a new office without offices.
     * @param name
     * @param address
     * @param phonenr
     */
    public Company(String name, Address address, int phonenr) {
        this.name = name;
        this.address = address;
        this.phonenr = phonenr;
        this.offices = new ArrayList<Office>();
        this.customers = new HashMap<Integer, Customer>();
    }

    /**
     * Creates a new company with offices.
     * @param name
     * @param address
     * @param phonenr
     * @param offices
     */
    public Company(String name, Address address, int phonenr, List<Office> offices) {
        this.name = name;
        this.address = address;
        this.phonenr = phonenr;
        this.offices = offices;
        this.customers = new HashMap<Integer, Customer>();
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

    public Map<Integer, Customer> getCustomers() {
        return customers;
    }

    /**
     * 
     * @param customer
     */
    public void addCustomer(Customer customer) {
        customers.put(customer.getPhonenr(), customer);
    }

    /**
     * 
     * @param phonenr
     * @return
     */
    public boolean hasCustomer(int phonenr) {
        return customers.containsKey(phonenr);
    }

    /**
     * 
     * @param office
     */
    public void addOffice(Office office) {
        offices.add(office);
    }

    @Override
    public String toString() {
        return "\n Name:" + name + "\nAddress:" + address + "\nPhone number:" + phonenr + "\n\n";
    }

}
