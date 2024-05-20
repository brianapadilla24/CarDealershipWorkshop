package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {

    static String filePath = "";

    /**
     * Retrieves dealership information from a file based on the name.
     */
    public static Dealership getDealership(String dealershipName) {
        filePath = "src/main/resources/" + dealershipName + ".csv";
        List<Vehicle> vehicles = new ArrayList<>();
        String name = "";
        String address = "";
        String phone = "";

        //Reading data from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            //Reading the dealership info.
            String firstLine = reader.readLine();
            String[] dealershipInfo = firstLine.split("\\|");
            name = dealershipInfo[0];
            address = dealershipInfo[1];
            phone = dealershipInfo[2];
            reader.readLine();//Skipping line so we can add vehicle inventory
            //Reading Vehicle Details from file
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                String vin = data[0];
                int year = Integer.parseInt(data[1]);
                String make = data[2];
                String model = data[3];
                String vehicleType = data[4];
                String color = data[5];
                double odometer = Double.parseDouble(data[6]);
                double price = Double.parseDouble(data[7]);
                //Creating Vehicle Object and add to list
                vehicles.add(new Vehicle(vin, year, make, model, vehicleType, color, odometer, price));
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Error reading inventory file: " + ex.getMessage()); //Fun Fact: "ex.getMessage()" will show exact error.
        }

        //Create Dealership object with retrieved data
        Dealership dealership = new Dealership(name, address, phone);
        dealership.setInventory(vehicles);
        return dealership;
    }


    /**
     * Saves dealership information to the file
     */
    public static void saveDealership(Dealership dealership){
        try(FileWriter writer = new FileWriter(filePath)){
            //Writing dealership info name/address/phone
            writer.write(dealership.getName()+"|"+dealership.getAddress()+"|"+dealership.getPhone()+"\n");

            //Writing vehicle inventory info
            for (Vehicle vehicle : dealership.getInventory()){
                writer.write(vehicle.toString() + "\n");
            }
        }catch (IOException ex){
            System.out.println("Error reading inventory file: " + ex.getMessage());
        }
    }

}