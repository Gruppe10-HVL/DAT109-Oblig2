package no.hvl.dat109.utils;

public class Address {

    private String street, postalAddress;
    private int postalCode;

    public Address(String street, int postalCode, String postalAddrress) {
        this.street = street;
        this.postalCode = postalCode;
        this.postalAddress = postalAddrress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

}
