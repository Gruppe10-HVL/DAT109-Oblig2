package no.hvl.dat109.model;

import java.util.ArrayList;
import java.util.List;

import no.hvl.dat109.util.Address;
import no.hvl.dat109.util.CreditCard;

public class Customer {

    private String firstname, surname;
    private Address address;
    private int phonenr;
    CreditCard creditCard;

    private List<Reservation> reservations;
    private List<Rental> rentals;

    /**
     * 
     * @param firstname
     * @param surname
     * @param address
     * @param phonenr
     */
    public Customer(String firstname, String surname, Address address, int phonenr) {
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
        this.phonenr = phonenr;
        this.creditCard = null;
        this.reservations = new ArrayList<Reservation>();
        this.rentals = new ArrayList<Rental>();
    }

    /**
     * Add reservation to a customer.
     * @param reservation Reservation to add to customer.
     */
    public void addReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    /**
     * Remove a reservation from customer.
     * @param reservation Reservation to be removed
     */
    public void removeReservation(Reservation reservation) {
        reservations.remove(reservation);
    }

    /**
     * Add a rental to a customer.
     * @param rental Rental to add to customer.
     */
    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getPhonenr() {
        return phonenr;
    }

    public void setPhonenr(int phonenr) {
        this.phonenr = phonenr;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    @Override
    public boolean equals(Object obj) {
        Customer customer;
        if (obj instanceof Customer) {
            customer = (Customer) obj;
            return this.getPhonenr() == customer.getPhonenr();
        }
        return false;
    }
}
