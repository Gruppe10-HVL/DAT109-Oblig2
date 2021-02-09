package no.hvl.dat109.utils;

public enum Group {
    
    A(100), 
    B(120),
    C(150), 
    D(200);

    public final int price;

    private Group(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}

