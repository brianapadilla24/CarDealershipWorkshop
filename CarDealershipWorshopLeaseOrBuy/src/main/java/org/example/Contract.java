package org.example;

//contract will be an abstract class
//total price and monthly payment
public abstract class Contract {
    //date, customer name, customer email, vehicle sold,
    private String dateOfContract;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;

    //constructor
    public Contract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    //get total price and get monthly payment
    //derived getters
    //abstract as well, because it varies
    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();

    //getter and setter
    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(Vehicle vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
}
