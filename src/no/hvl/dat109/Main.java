package no.hvl.dat109;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import no.hvl.dat109.constants.*;
import no.hvl.dat109.models.Vehicle;
import no.hvl.dat109.utils.Group;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        Scanner scanner = new Scanner(System.in);
        String username;
        Boolean accepted = false;
        LocalDateTime fromDate, toDate;

        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder().parseCaseInsensitive().parseLenient()
                .parseDefaulting(ChronoField.YEAR_OF_ERA, 2021L).appendPattern("[dd-MM-yyyy HH:mm]")
                .appendPattern("[dd-MM-yyyy]").appendPattern("[dd-MM-yyyy HH:mm:ss]").appendPattern("[yyyy-MM-dd]");
        DateTimeFormatter formatter = builder.toFormatter(Locale.ENGLISH);

        System.out.println("Vennligst logg inn med brukernavn");
        username = scanner.next(); // Dummy logic
        if (username != null) {
            System.out.println("Success");

        } else {
            System.out.println("Please give some semblance of input");
            scanner.close();
            return;
        }
        /*
         * NEED TO FIX DATE FORMATTING
         */
        System.out.println("When do you wish to rent the vehicle from?");
        System.out.println("Please specify a date in the format of: dd-MM-yyyy HH:mm");
        fromDate = LocalDateTime.parse(scanner.next(), formatter);
        System.out.println("When do you wish to rent the vehicle to?");
        System.out.println("Please specify a date in the format of: dd-MM-yyyy HH:mm");
        toDate = LocalDateTime.parse(scanner.next(), formatter);

        while (!accepted) {
            String models = "Which vehicle do you wish to reserve?\n"
                    .concat("You may choose from our four price classes: \n");
            for (Group g : Group.values()) {
                models.concat(g.name() + "Price:" + g.getPrice() + " \n");
            }
            System.out.println(models);
            Group vehicleGroup = Group.valueOf(scanner.next());
            // Vehicle vehicle = new Vehicle(); //Query for a vehicle in rental controller.
            Vehicle vehicle = new Vehicle(true); // Temporary for testing, replace with actual vehicle object later.
            System.out.println("We have found this vehicle, from your chosen class");
            System.out.println(vehicle.toString());
            System.out.println("Do you wish to rent this vehicle? (Yes/no)");
            accepted = scanner.next().toLowerCase() == "yes" ? true : false;
        }

        // Handle reservation in controller
        System.out.println("The specified vehicle has been reserved from:");
        System.out.println(fromDate);
        System.out.println("The specified vehicle has been reserved to:");
        System.out.println(toDate);

        System.out.println("Payment will be done on pickup.");
        System.out.println("Thank you for using Rent-a-complete-wreck Bilutleie AS");
        scanner.close();
    }

}
