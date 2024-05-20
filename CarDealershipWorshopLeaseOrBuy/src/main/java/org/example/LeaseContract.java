package org.example;

public class LeaseContract extends Contract {
    //expected ending value (50% of the price)
    //lease fee (7% of the price)
    //monthly payment on 4.0% for 36 months
    private double expectedEndingValue;
    private double leaseFee;

    //constructor

    //removed this class  objects in constructor???????????????
    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = expectedEndingValue;
        this.leaseFee = leaseFee;
    }

    //getters and setters

    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    //lease fee and the price
    @Override
    public double getTotalPrice() {
        return leaseFee + getVehicleSold().getPrice();
    }

    //expected ending value/36 months
    //0.04 for 36 months (3 years)
    @Override
    public double getMonthlyPayment() {
        //EEVM: Expected Ending Value By 36 Months
        double EEVM = expectedEndingValue/36;
        double moneyFactorValue = ((double) 4 / 2400);
        double leaseCalculate = (expectedEndingValue + getVehicleSold().getPrice() * moneyFactorValue);
        double monthOfLease = leaseFee / 36;
        return EEVM + leaseCalculate + monthOfLease;

    }
}
