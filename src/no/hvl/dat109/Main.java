package no.hvl.dat109;

import java.util.Scanner;
import no.hvl.dat109.controllers.ReservationControllerImpl;
import no.hvl.dat109.controllers.RentalControllerImpl;
import no.hvl.dat109.controllers.ReturnControllerImpl;
import no.hvl.dat109.utils.Address;
import no.hvl.dat109.models.Company;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        Company c = new Company("test", new Address("null", 123, "null"), "12345678"); // Dummy company, remove later.
        System.out.println("Hello and welcome to Rent-a-complete-wreck Bilutleie AS");
        while (!exit) {
            System.out.println("Would you like to:");
            System.out.println("1. Make a reservation");
            System.out.println("2. Finalize and pick up your reserved car");
            System.out.println("3. Return your rental vehicle");
            System.out.println("4. Exit our customer system.");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    ReservationControllerImpl.bookVehicle(c);
                    break;

                case 2:
                    RentalControllerImpl.rental(c);
                    break;
                case 3:
                    ReturnControllerImpl.returnVehicle(c);
                    break;

                case 4:
                    exit = true;
                    break;

                default:
                    System.out.println("Please make a valid selection.");
                    break;
            }
        }
        System.out.println("Thank you for using Rent-a-complete-wreck Bilutleie AS.");
        sc.close();
    }

}
