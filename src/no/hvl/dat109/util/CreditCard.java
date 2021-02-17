package no.hvl.dat109.util;

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

    public void setCardNumber(long creditCardNr) {
        this.creditcardNumber = creditCardNr;
    }
    
    /**
     * 
     * @return
     */
    public boolean validate() {
        String creditCardString = ("" + creditcardNumber);
        return creditCardString.length() == 16;
    }
}
