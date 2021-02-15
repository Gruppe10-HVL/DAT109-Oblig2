package no.hvl.dat109.models;

import java.time.LocalDate;

import no.hvl.dat109.utils.CreditCard;
import no.hvl.dat109.utils.Address;

public class Customer {

    private String firstname, surname;
    private Address address; // Change to address object later
    private int phonenr;
    CreditCard creditCard;

    public Customer(String firstname, String surname, Address address, int phonenr) {
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
        this.phonenr = phonenr;
        this.creditCard = null;
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
}
