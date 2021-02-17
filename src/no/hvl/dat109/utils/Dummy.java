package no.hvl.dat109.utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.hvl.dat109.models.Company;
import no.hvl.dat109.models.Office;
import no.hvl.dat109.models.Vehicle;

public class Dummy {

    public static List<Company> dummyCompanies() {
        Company[] companies = new Company[] { dummyCompany1(),
                new Company("Rent a wrecker Bilutleie AS", new Address("Bergensveien 40", 5075, "Bergen"), 48345678),
                new Company("Avisos", new Address("Bergensveien 41", 5075, "Bergen"), 53345678),
                new Company("Normal cars rental AS", new Address("Bergensveien 45", 5075, "Bergen"), 47345678) };
        return Arrays.asList(companies);
    }

    public static Company dummyCompany1() {
        return new Company("Bergen Internationale Bilutleigeselskab", new Address("Bergensveien 45", 5075, "Bergen"),
                63345678, dummyOffices());
    }

    public static List<Office> dummyOffices() {
        Office off[] = new Office[] {
                new Office(1, new Address("Bergensveien 46", 5075, "Bergen"), 99111111, Dummy.dummyVehicleList()),
                new Office(2, new Address("Osloveien 2", 0073, "Oslo"), 98111111, Dummy.dummyVehicleList2()),
                new Office(3, new Address("Trondheimsveien 4", 6700, "Trondheim"), 97111111, Dummy.dummyVehicleList3()),
                new Office(4, new Address("Moldeveien 1", 3000, "Vestnes"), 96111111, Dummy.dummyVehicleList4()) };
        return Arrays.asList(off);
    }

    public static Map<String, Vehicle> dummyVehicleList() {
        Map<String, Vehicle> dummyVehicles = new HashMap<>();
        dummyVehicles.put("ST1", new Vehicle("ST1", "BMW", "320d", Group.MEDIUM, 122000));
        dummyVehicles.put("ST2", new Vehicle("ST2", "Audi", "A2", Group.SMALL, 254000));
        dummyVehicles.put("ST3", new Vehicle("ST3", "Alfa Romeo", "Julia", Group.MEDIUM, 512000));
        dummyVehicles.put("ST4", new Vehicle("ST4", "Lancia", "Delta integrale", Group.MEDIUM, 612000));
        dummyVehicles.put("ST5", new Vehicle("ST5", "Peugot", "307", Group.SMALL, 32000));
        dummyVehicles.put("ST6", new Vehicle("ST6", "VW", "Passat", Group.STATION_WAGON, 41000));
        dummyVehicles.put("ST7", new Vehicle("ST7", "VW", "boble", Group.MEDIUM, 214200));
        dummyVehicles.put("ST8", new Vehicle("ST8", "Porsche", "Spyder", Group.BIG, 1422000));
        dummyVehicles.put("ST9", new Vehicle("ST9", "Ferrarri", "LaFerrari", Group.MEDIUM, 214000));
        return dummyVehicles;
    }

    public static Map<String, Vehicle> dummyVehicleList2() {
        Map<String, Vehicle> dummyVehicles = new HashMap<>();
        dummyVehicles.put("ST12", new Vehicle("ST12", "BMW", "320d", Group.MEDIUM, 122000));
        dummyVehicles.put("ST22", new Vehicle("ST22", "Audi", "A2", Group.SMALL, 254000));
        dummyVehicles.put("ST32", new Vehicle("ST32", "Alfa Romeo", "Julia", Group.MEDIUM, 512000));
        dummyVehicles.put("ST42", new Vehicle("ST42", "Lancia", "Delta integrale", Group.MEDIUM, 612000));
        dummyVehicles.put("ST52", new Vehicle("ST52", "Peugot", "307", Group.SMALL, 32000));
        dummyVehicles.put("ST62", new Vehicle("ST62", "VW", "Passat", Group.STATION_WAGON, 41000));
        dummyVehicles.put("ST72", new Vehicle("ST72", "VW", "boble", Group.MEDIUM, 214200));
        dummyVehicles.put("ST82", new Vehicle("ST82", "Porsche", "Spyder", Group.BIG, 1422000));
        dummyVehicles.put("ST92", new Vehicle("ST92", "Ferrarri", "LaFerrari", Group.MEDIUM, 214000));
        return dummyVehicles;
    }

    public static Map<String, Vehicle> dummyVehicleList3() {
        Map<String, Vehicle> dummyVehicles = new HashMap<>();
        dummyVehicles.put("ST13", new Vehicle("ST13", "BMW", "320d", Group.MEDIUM, 122000));
        dummyVehicles.put("ST23", new Vehicle("ST23", "Audi", "A2", Group.SMALL, 254000));
        dummyVehicles.put("ST33", new Vehicle("ST33", "Alfa Romeo", "Julia", Group.MEDIUM, 512000));
        dummyVehicles.put("ST43", new Vehicle("ST43", "Lancia", "Delta integrale", Group.MEDIUM, 612000));
        dummyVehicles.put("ST53", new Vehicle("ST53", "Peugot", "307", Group.SMALL, 32000));
        dummyVehicles.put("ST63", new Vehicle("ST63", "VW", "Passat", Group.STATION_WAGON, 41000));
        dummyVehicles.put("ST73", new Vehicle("ST73", "VW", "boble", Group.MEDIUM, 214200));
        dummyVehicles.put("ST83", new Vehicle("ST83", "Porsche", "Spyder", Group.BIG, 1422000));
        dummyVehicles.put("ST93", new Vehicle("ST93", "Ferrarri", "LaFerrari", Group.MEDIUM, 214000));
        return dummyVehicles;
    }

    public static Map<String, Vehicle> dummyVehicleList4() {
        Map<String, Vehicle> dummyVehicles = new HashMap<>();
        dummyVehicles.put("ST14", new Vehicle("ST14", "BMW", "320d", Group.MEDIUM, 122000));
        dummyVehicles.put("ST24", new Vehicle("ST24", "Audi", "A2", Group.SMALL, 254000));
        dummyVehicles.put("ST34", new Vehicle("ST34", "Alfa Romeo", "Julia", Group.MEDIUM, 512000));
        dummyVehicles.put("ST44", new Vehicle("ST44", "Lancia", "Delta integrale", Group.MEDIUM, 612000));
        dummyVehicles.put("ST54", new Vehicle("ST54", "Peugot", "307", Group.SMALL, 32000));
        dummyVehicles.put("ST64", new Vehicle("ST64", "VW", "Passat", Group.STATION_WAGON, 41000));
        dummyVehicles.put("ST74", new Vehicle("ST74", "VW", "boble", Group.MEDIUM, 214200));
        dummyVehicles.put("ST84", new Vehicle("ST84", "Porsche", "Spyder", Group.BIG, 1422000));
        dummyVehicles.put("ST94", new Vehicle("ST94", "Ferrarri", "LaFerrari", Group.MEDIUM, 214000));
        return dummyVehicles;
    }

}
