package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    /**
     * Constructor to initialize a Dealership with name, address, and phone.
     */

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(List<Vehicle> inventory) {
        this.inventory = inventory;
    }

    /**
     * Add a vehicle to the dealership's inventory.
     */

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
        DealershipFileManager.saveDealership(this);
    }

    /**
     * Get all vehicles in the dealership's inventory.
     */

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

}
