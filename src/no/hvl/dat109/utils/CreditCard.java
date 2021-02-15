package no.hvl.dat109.utils;

public class CreditCard {

    long creditcardNumber;

    public CreditCard(long creditcardNumber) {
        this.creditcardNumber = creditcardNumber;
    }

    public long getCreditcardNumber() {
        return creditcardNumber;
    }

    public void setCreditcardNumber(long creditcardNumber) {
        this.creditcardNumber = creditcardNumber;
    }

    public boolean validate() {
        String creditCardString = ("" + creditcardNumber);
        return creditCardString.length() == 16;
    }

}
