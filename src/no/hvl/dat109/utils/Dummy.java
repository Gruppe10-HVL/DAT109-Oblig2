package no.hvl.dat109.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hvl.dat109.models.Company;
import no.hvl.dat109.models.Office;
import no.hvl.dat109.models.Vehicle;

public class Dummy {

    public static Map<String, Vehicle> dummyVehicleList() {
        Map<String, Vehicle> dummyVehicles = new HashMap<>();
        dummyVehicles.put("st1", new Vehicle("st1", "BMW", "320d", Group.MEDIUM, 122000));
        dummyVehicles.put("st2", new Vehicle("st2", "Audi", "A2", Group.MEDIUM, 254000));
        dummyVehicles.put("st3", new Vehicle("st3", "Alfa Romeo", "Julia", Group.MEDIUM, 512000));
        dummyVehicles.put("st4", new Vehicle("st4", "Lancia", "Delta integrale", Group.MEDIUM, 612000));
        dummyVehicles.put("st5", new Vehicle("st5", "Peugot", "307", Group.MEDIUM, 32000));
        dummyVehicles.put("st6", new Vehicle("st6", "Seat", "fiesta", Group.MEDIUM, 41000));
        dummyVehicles.put("st7", new Vehicle("st7", "VW", "boble", Group.MEDIUM, 214200));
        dummyVehicles.put("st8", new Vehicle("st8", "Porsche", "Spyder", Group.MEDIUM, 1422000));
        dummyVehicles.put("st9", new Vehicle("st9", "Ferrarri", "LaFerrari", Group.MEDIUM, 214000));
        return dummyVehicles;
    }

    public static Company dummyCompany() {
        return new Company("test", new Address("null", 123, "null"), 12345678);
    }

    public static List<Office> dummyOffices() {
        Office off[] = new Office[] { new Office(1, new Address("", 0, ""), 1, Dummy.dummyVehicleList()),
                new Office(2, new Address("", 0, ""), 2, Dummy.dummyVehicleList()),
                new Office(3, new Address("", 0, ""), 3, Dummy.dummyVehicleList()),
                new Office(4, new Address("", 0, ""), 4, Dummy.dummyVehicleList()) };

        return Arrays.asList(off);
    }

}
