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
        Company[] companies = new Company[] { dummyCompany1(), dummyCompany2(), dummyCompany3(), dummyCompany4() };
        return Arrays.asList(companies);
    }

    public static Company dummyCompany1() {
        return new Company("Rent a complete wreck Bilutleie AS", new Address("Bergensveien 45", 5075, "Bergen"),
                63345678);
    }

    public static Company dummyCompany2() {
        return new Company("Rent (almost) a wreck Bilutleie AS", new Address("Bergensveien 40", 5075, "Bergen"),
                48345678);
    }

    public static Company dummyCompany3() {
        return new Company("Avisos", new Address("Bergensveien 41", 5075, "Bergen"), 53345678);
    }

    public static Company dummyCompany4() {
        return new Company("Bergen Internasjonale Bilutleieselskab", new Address("Bergensveien 45", 5075, "Bergen"),
                47345678);
    }

    public static List<Office> dummyOffices() {
        Office off[] = new Office[] {
                new Office(1, new Address("Bergensveien 46", 5075, "Bergen"), 99111111, Dummy.dummyVehicleList()),
                new Office(2, new Address("Osloveien 2", 0073, "Oslo"), 98111111, Dummy.dummyVehicleList()),
                new Office(3, new Address("Trondheimsveien 4", 6700, "Trondheim"), 97111111, Dummy.dummyVehicleList()),
                new Office(4, new Address("Moldeveien 1", 3000, "Vestnes"), 96111111, Dummy.dummyVehicleList()) };
        return Arrays.asList(off);
    }

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

    public static Map<String, Vehicle> dummyVehicleList2() {
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

    public static Map<String, Vehicle> dummyVehicleList3() {
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

    public static Map<String, Vehicle> dummyVehicleList4() {
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

}
