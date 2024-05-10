package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Vehicle> dealership1Inventory;
    private List<Vehicle> dealership2Inventory;
    private String name;
    private String address;
    private String phone;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Dealership(String dealership1File, String dealership2File){
        this.dealership1Inventory = loadInventory(dealership1File);
        this.dealership2Inventory = loadInventory(dealership2File);

    }
    private List<Vehicle> loadInventory(String filename) {
        List<Vehicle> inventory = new List<Vehicle>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");
                double price = Double.parseDouble(data[0]);
                String make = data[1];
                String model = data[2];
                int year = Integer.parseInt(data[3]);
                String color = data[4];
                double mileage = Double.parsedouble(data[5]);
                String type = data[6];
                Vehicle vehicle = new Vehicle(price,make, model, year, color, mileage, type);
                inventory.add(vehicle);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inventory;
    }
    public void filterByCriteria(String criteria, String filterType){
        List<Vehicle> filteredVehicles = new ArrayList<>();
        for (Vehicle vehicle : dealership1Inventory){
            if (matchesCriteria(vehicle, criteria, filterType)){
                filteredVehicles.add(vehicle);
            }
        }
        for (Vehicle vehicle : dealership2Inventory){
            if (matchesCriteria(vehicle, criteria, filterType)){
                filteredVehicles.add(vehicle);
            }
        }
        if (filteredVehicles.isEmpty()){
            System.out.println("No vehicles match the Criteria.");
        }else {
            displayInventory();
        }

    }
    private boolean matchesCriteria(Vehicle vehicle, String criteria, String filterType){
        if (filterType.equals("price")) {
            String[] priceRange = criteria.split("-");
            int minPrice = Integer.parseInt(priceRange[0]);
            int maxPrice = Integer.parseInt(priceRange[1]);
            return vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice;
        }
        return matchesCriteria(vehicle,criteria,filterType);

    }
    public void filterByPrice(int minPrice, int maxPrice,List<Vehicle> vehicle){
        System.out.println("Vehicles Within Price Range $" + minPrice + " - $" + maxPrice + ": ");
        filterByCriteria(minPrice + "-" + maxPrice ,"Price");
    }
    public void filterByMakeAndModel(String make, String model,List<Vehicle> vehicle){
        filterByCriteria(make + "/" + model,"Make/Model");
    }
    public void filterByYear(int year,List<Vehicle> vehicle){
        System.out.println("Vehicles for : " + year);
        filterByCriteria(year + ":","year");
    }
    public void filterByColor(String color,List<Vehicle> vehicle){
        System.out.println("Vehicles in color: " + color);
        filterByCriteria(color + ":","color");
    }
    public void filterByMileage(double mileage,List<Vehicle> vehicle){
        System.out.println("Vehicles with: " + mileage);
        filterByCriteria(mileage + ":","mileage");
    }
    public void filterByType(String type,List<Vehicle> vehicle){
        System.out.println("Vehicle type: " + type);
        filterByCriteria(type + ":","type");
    }

}
