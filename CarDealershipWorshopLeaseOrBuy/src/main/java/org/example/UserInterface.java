package org.example;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface() {
        this.dealership = null;
    }

    public void getDealership(){
        System.out.println("""
                                         Howdy!
                    Pick a dealership! Careful! Don't pick the wrong one...
                
                                    CascadeAutoSales
                                          OR
                                      SummitMotors"""); //Loads Dealership
        Dealership dealership = DealershipFileManager.getDealership(scanner.nextLine());
        setDealership(dealership);
    }

    public void display() {
        while (true) { // loop indefinitely until user chooses to exit

            System.out.println("""
                \\______________________/
                  __/__|_________|__\\__
                /⭕⭕____________⭕⭕\\
                |_____/___________\\_____|
                \\💥💥__|_|_|__|_|__💥💥/
                
                       -Vroooom-
                
                Welcome welcome!!
                1. Add a vehicle.
                2. Display our stock!
                3. Check out our cars by their pricing!
                4. Display our cars by make & model!!
                5. Check them out by year!
                6. Or by color?
                7. Maybe you want ta see 'em by mileage?
                8. Look at 'em all by type!
                9. Remove a vehicle
                10. **Buy or Lease a Vehicle with Dealership**
                00. Hey hey where you goin'!??! (Exit)
                
                What you lookin' for?""");

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
                case 10:
                    saleOrLeaseCar();
                    break;
                case 00:
                    System.out.println("\nSo Long SUCKER (Exiting)");
                    return;
                default:
                    System.out.println("\nMake some SENSE! (Invalid Choice)");
            }
        }
    }

    /**
     * Sets the current dealership.
     */
    //private void init() setting the dealership
    public void setDealership(Dealership dealership) {
        this.dealership = dealership;
    }

    public void processGetByPriceRequest() {
        System.out.println("How low you willin' to go?(Minimum Price):\n");
        double minPrice = scanner.nextDouble();
        System.out.println("Whats your max budget lookin' like?(Maximum Price):");
        double maxPrice = scanner.nextDouble();

        //retrieve vehicles by price range form the dealership
        List<Vehicle> vehicles = dealership.getVehiclesByPrice(minPrice,maxPrice);

        //display the retrieved vehicles
        if(vehicles.isEmpty()) {
            System.out.println("Couldn't make any sense of your jibberish! Try again bucko(No vehicles found in the specified price range.)");
        }
        else {
            System.out.println("This is what I got that fits your description:");
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
            System.out.println("Nothin' found in that make & model.");
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
            System.out.println("Nothin' found for that year buddy.");
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
            System.out.println("Nothin' in that color fella.");
        } else {
            System.out.println("Here's what I got in that color");
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
            System.out.println("No can do. Nothing in that mileage.");
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
            System.out.println("Nothin' in that type buddy. Try again.");
        } else {
            System.out.println("Vehicles for the specified Type: ");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);

            }
        }
    }


    // Process All Vehicle Request
    public void processGetAllVehiclesRequest() {

        // Retrieve all vehicles from dealership inventory
        List<Vehicle> vehicles = dealership.getAllVehicles();
        if (vehicles.isEmpty()) {
            System.out.println("WE'RE ALL OUT OF CARS! EVERYONE PANIC");
        } else {
            // Display all vehicles
            System.out.println("Dealership Inventory:");
            for (Vehicle vehicle : vehicles) {
                System.out.println(vehicle);
            }
        }
    }

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

    public void processRemoveVehicleRequest(){
        System.out.println("Please enter VIN Number: ");
        String vinNumber = scanner.nextLine();

        List<Vehicle> vehicles = dealership.getInventory();

        for (Vehicle vehicle : vehicles){
            if (vinNumber.equalsIgnoreCase(vehicle.getVin())){
                dealership.removeVehicle(vehicle);
                System.out.println("Vehicle with VIN " + vinNumber + " removed successfully.");
                break;
            }
        }
        System.out.println("Vehicle Removed");
    }

    public void saleOrLeaseCar() {
        System.out.println("Welcome!");
        System.out.println("      1) Lease a vehicle?");
        System.out.println("      2) Buy a vehicle?");

        int userInput = scanner.nextInt();

        switch (userInput) {
            case 1:
                leaseVehicle();
                break;
            case 2:
                sellVehicle();
                break;
            default:
                System.out.println("Incorrect.");
        }

    }

    public void sellVehicle() {
        System.out.println("Please enter the vehicle's VIN:");
        scanner.nextLine();
        String vinNumber = scanner.nextLine();

        Vehicle vehicle = dealership.findVehicleVinNumber(vinNumber);

        if (vehicle == null) {
            System.out.println("Incorrect Vin Number.");
            return;
        }

        System.out.println("Now lets set up your contract. Please type in following questions.");

        System.out.println("Enter Contract Date: yyyymmdd ");
        String dateOfContract = scanner.nextLine();

        System.out.println("Enter Customers Name: ");
        String customerName = scanner.nextLine();

        System.out.println("Enter Customer's Email: ");
        String customerEmail = scanner.nextLine();

        System.out.println("Do you want to finance? yes or no?: ");
        String financeYesOrNo = scanner.nextLine();

        boolean booleanFinanceYesOrNo = financeYesOrNo.equalsIgnoreCase(" yes ");

        SalesContract salesContract = new SalesContract(dateOfContract, customerName, customerEmail, vehicle, booleanFinanceYesOrNo);

        ContractFileManager.vehicleContract(salesContract);
        System.out.println("Your Contract Information has been saved.");

        //remove the vehicle
        dealership.removeVehicle(vehicle);

    }

    public void leaseVehicle() {
        System.out.println("Thank you for Leasing! Now, please enter the following information... ");

        System.out.println("Enter Vehicle's Vin Number: ");
        scanner.nextLine();
        String vinNumber = scanner.nextLine();

        Vehicle vehicle = dealership.findVehicleVinNumber(vinNumber);

        if (vehicle == null) {
            System.out.println("Incorrect. ");
            return;
        }

        System.out.println("Lets set up your Contract! ");

        System.out.println("Enter Contract Date: yyyymmdd: ");

        String dateOfContract = scanner.nextLine();

        System.out.println("Enter Customer's Name: ");
        String customerName = scanner.nextLine();

        System.out.println("Enter Customer's Email: ");
        String customerEmail = scanner.nextLine();

        LeaseContract leaseContract = new LeaseContract(dateOfContract, customerName, customerEmail, vehicle);

        ContractFileManager.vehicleContract(leaseContract);

        System.out.println("Thank you for Leasing with us!");

        //remove
        dealership.removeVehicle(vehicle);
    }


}