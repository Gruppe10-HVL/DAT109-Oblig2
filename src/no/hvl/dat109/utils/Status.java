package no.hvl.dat109.utils;

/**
 * 
 * Maybe delete class
 * 
 */
public enum Status {
    O("Ongoing"), F("Finished"), C("Cancelled");

    public final String full;

    private Status(String full) {
        this.full = full;
    }

    public String getFull() {
        return this.full;
    }
}
