package no.hvl.dat109.model;

import no.hvl.dat109.util.Address;
import no.hvl.dat109.util.CreditCard;

public class Customer {

    private String firstname, surname;
    private Address address;
    private int phonenr;
    CreditCard creditCard;

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
