package no.hvl.dat109.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import no.hvl.dat109.models.Company;
import no.hvl.dat109.models.Office;
import no.hvl.dat109.models.Reservation;
import no.hvl.dat109.models.Return;
import no.hvl.dat109.models.Vehicle;
import no.hvl.dat109.utils.CreditCard;

public class ReturnControllerImpl {

    public ReturnControllerImpl() {
        
    }

    public static boolean returnVehicle(Company company) {
        Scanner sc = new Scanner(System.in);
        LocalDate currentDate = LocalDate.now();

        System.out.println("Phone number:");
        int phonenr = sc.nextInt();
        sc.nextLine();

        List<Reservation> allReservations = company.getReservations();

        Reservation reservation = allReservations.stream().filter(r -> phonenr == r.getCustomer().getPhonenr())
                .findAny().orElse(null);

        if (reservation == null) {
            System.out.println("No reservation with that phone number.");
            sc.close();
            return false;
        }

        System.out.println("Enter current mileage:");
        int mileage = sc.nextInt();
        sc.nextLine();

        Vehicle vehicle = reservation.getVehicle();
        vehicle.setMileage(mileage);
        vehicle.setAvailable(true);

        Office returnOffice = reservation.getReturnOffice();
        returnOffice.addVehicle(vehicle);

        System.out.println("Receit sent.");
        CreditCard creditCard = reservation.getCustomer().getCreditCard();

        allReservations.remove(reservation);

        Return returnVehicle = new Return(creditCard, currentDate, vehicle.getRegnr(), mileage);
        List<Return> returnedVehicles = company.getReturnedCars();
        returnedVehicles.add(returnVehicle);

        sc.close();
        return true;
        // TODO: return to client

    }
}
