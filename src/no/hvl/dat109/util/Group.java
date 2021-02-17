package no.hvl.dat109.util;

public enum Group {

    SMALL(100), MEDIUM(120), BIG(150), STATION_WAGON(200);

    public final int price;

    /*
     * @Constructor
     */
    private Group(int price) {
        this.price = price;
    }

    /*
     * @return daily price of vehicle class
     */
    public int getPrice() {
        return this.price;
    }

}
