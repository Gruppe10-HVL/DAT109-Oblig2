package no.hvl.dat109.utils;

public enum Group {

    SMALL(100), MEDIUM(120), BIG(150), STATION_WAGON(200);

    public final int price;

    private Group(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}
