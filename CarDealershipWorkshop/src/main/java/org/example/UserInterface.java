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

    //load dealership
    public void display() {
        System.out.println("First Type in your dealership");
        Dealership dealership = DealershipFileManager.getDealership(scanner.nextLine());
        setDealership(dealership);
        System.out.println("Welcome to the Dealership Management System!");
        System.out.println("1. Add a vehicle");
        System.out.println("2. Get all vehicles");
        System.out.println("3. Get vehicles by price");
        System.out.println("4. Get vehicles by make and model");
        System.out.println("5. Get vehicles by year");
        System.out.println("6. Get vehicles by color");
        System.out.println("7. Get vehicles by mileage");
        System.out.println("8. Get vehicles by type");
        System.out.println("9. Remove a vehicle");
        System.out.println("0. Exit");
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
            case 3:
                processGetByPriceRequest();
                break;
            case 4:
                processGetByMakeModelRequest();
                break;
            case 5:
                processGetByYearRequest();
                break;
            case 6:
                processGetByColorRequest();
                break;
            case 7:
                processGetByMileage();
                break;
            case 8:
                processGetByVehicleTypeRequest();
                break;
            case 9:
                processRemoveVehicleRequest();
                break;
            case 0:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice!");
        }
    }

    /**
     * Sets the current dealership.
     */
    //private void init() setting the dealership
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


        //process to remove vehicle request
        System.out.println("Enter VIN of the vehicle to remove:");
        String vinToRemove = scanner.next();


    }


    /**
     * Processes the request to get all vehicles from the dealership's inventory.
     */

    //Process Get By Price Request
    public void processGetByPriceRequest() {
        System.out.println("Enter minimum price:");
        double minPrice = scanner.nextDouble();
        System.out.println("Enter max price:");
        double maxPrice = scanner.nextDouble();

        //retrieve vehicles by price range form the dealership
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice,maxPrice);

        //display the retrieved vehicles
        if(vehicles.isEmpty()) {
            System.out.println("No vehicles found in the specified price range.");
        }
        else {
            System.out.println("Vehicles in the specified price range: ");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }

    }

    //Process Get By Make Model Request
    public void processGetByMakeModelRequest() {
        System.out.println("Enter make: ");
        String make = scanner.next();
        System.out.println("Enter model: ");
        String model = scanner.next();

        //retrieve vehicles by make and model from the dealership
        List<Vehicle> vehicles = dealership.getVehiclesByMakeModel(make, model);

        //display the retrieved vehicles
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found for the specified make and model.");
        }
        else {
            System.out.println("Vehicles for the specified make and model:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }

    }

    //Process Get By Year request
    public void processGetByYearRequest() {
        System.out.println("Enter Minimum Year: ");
        int minYear = scanner.nextInt();
        System.out.println("Enter Maximum Year: ");
        int maxYear = scanner.nextInt();

        //retrieve vehicles by year from the dealership
        List<Vehicle> vehicles = dealership.getVehiclesByYear(minYear,maxYear);

        //display the retrieved vehicles
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found for the specified Year.");
        } else {
            System.out.println("Vehicles for the specified Year: ");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);

            }
        }
    }


    //Process Get By Color Request
    public void processGetByColorRequest() {
        System.out.println("Enter Color: ");
        String color = scanner.next();

        //retrieve vehicles by make and model from the dealership
        List<Vehicle> vehicles = dealership.getVehiclesByColor(color);

        //display the retrieved vehicles
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found in your color.");
        } else {
            System.out.println("Vehicles for the specified color:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);

            }
        }
    }

   //Process Get By Mileage
    public void processGetByMileage() {
        System.out.println("Enter Min Mileage: ");
        double minMileage = scanner.nextDouble();
        System.out.println("Enter Max Mileage: ");
        double maxMileage = scanner.nextDouble();

        //retrieve vehicles by make and model from the dealership
        List<Vehicle> vehicles = dealership.getVehiclesByMileage(minMileage, maxMileage);

        //display the retrieved vehicles
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found for the specified mileage requested.");
        } else {
            System.out.println("Vehicles for the specified mileage:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);

            }
        }
    }

    // Process Get By Vehicle Type Request
    public void processGetByVehicleTypeRequest() {
        System.out.println("Enter Type: ");
        String type = scanner.next();

        //retrieve vehicles by make and model from the dealership
        List<Vehicle> vehicles = dealership.getVehiclesByType(type);

        //display the retrieved vehicles
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found for your Type.");
        } else {
            System.out.println("Vehicles for the specified Type: ");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);

            }
        }
    }


    // Process All Vehicle Request
    public void processGetAllVehiclesRequest() {
        System.out.println("All Vehicle Requests: ");
        String requests = scanner.next();

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

    //andrew review
    public void processRemoveVehicleRequest()  {
        System.out.println("Remove Vehicle Request: ");
        String vehicle = scanner.next();

        //retrieve vehicles by make and model from the dealership
        List<Vehicle> vehicles = dealership.removeVehicle(//Vehicle vehicle);

        //display the retrieved vehicles
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles found for the specified make and model.");
        }
        else {
            System.out.println("Vehicles for the specified make and model:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }
}