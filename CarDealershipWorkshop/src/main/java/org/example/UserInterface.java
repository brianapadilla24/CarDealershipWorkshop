package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface() {
        this.dealership = null;
    }

    /**
     * Displays the main menu of the Dealership Management System.
     */

    public void display() {
        System.out.println("First Type in your dealership");
        Dealership dealership = DealershipFileManager.getDealership(scanner.nextLine());
        setDealership(dealership);
        System.out.println("Welcome to the Dealership Management System!");
        System.out.println("1. Add a vehicle");
        System.out.println("2. Get all vehicles");
        System.out.println("Enter your choice:");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                processAddVehicleRequest();
                break;
            case 2:
                processGetAllVehiclesRequest();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    /**
     * Sets the current dealership.
     */

    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    /**
     * Processes the request to add a vehicle to the dealership's inventory.
     */

    public void processAddVehicleRequest() {
        System.out.println("Enter VIN:");
        String vin = scanner.next();
        System.out.println("Enter year:");
        int year = scanner.nextInt();
        System.out.println("Enter make:");
        String make = scanner.next();
        System.out.println("Enter model:");
        String model = scanner.next();
        System.out.println("Enter vehicle type:");
        String vehicleType = scanner.next();
        System.out.println("Enter color:");
        String color = scanner.next();
        System.out.println("Enter odometer reading:");
        int odometer = scanner.nextInt();
        System.out.println("Enter price:");
        double price = scanner.nextDouble();

        // Create Vehicle object with user input
        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);

        // Add vehicle to dealership inventory
        dealership.addVehicle(vehicle);
    }

    /**
     * Processes the request to get all vehicles from the dealership's inventory.
     */

    public void processGetAllVehiclesRequest() {
        // Retrieve all vehicles from dealership inventory
        List<Vehicle> vehicles = dealership.getAllVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found in inventory.");
        } else {
            // Display all vehicles
            System.out.println("Dealership Inventory:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }
}