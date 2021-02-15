package no.hvl.dat109.models;

import java.time.LocalDateTime;

public class Customer {
    
    private String firstname, surname;
    private Address address; // Change to address object later
    private int phonenr;

    public Customer(String firstname, String surname, Address address, int phonenr) {
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
        this.phonenr = phonenr;
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

}
