package no.hvl.dat109;

import java.util.List;
import java.util.Scanner;
import no.hvl.dat109.controllers.RentalControllerImpl;
import no.hvl.dat109.utils.Dummy;
import no.hvl.dat109.models.Company;

public class Client {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        Company company = Dummy.dummyCompany1();
        System.out.println("Hello and welcome to" + company.getName());
        RentalControllerImpl controller = new RentalControllerImpl(company);

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
                    controller.bookVehicle();
                    break;

                case 2:
                    controller.rentVehicle();
                    break;
                case 3:
                    controller.returnVehicle();
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
