package org.example;

//extend Contract
public class SalesContract extends Contract {
    //sales tax amount, recording fee, processing fee, finance?, monthly payments
    private double salesTax;
    private double recordingFee;
    private double processingFee;
    private boolean financeYesOrNo;

    //constructor

//removed the objects from this class???????????????????????????????????????????
    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean financeYesOrNo) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.financeYesOrNo = financeYesOrNo;
    }

    //getters and setters


    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanceYesOrNo() {
        return financeYesOrNo;
    }

    public void setFinanceYesOrNo(boolean financeYesOrNo) {
        this.financeYesOrNo = financeYesOrNo;
    }

    //we need to output the String option whether they want to finance yes or no

    public String QuestionIsFinance(){
        if(isFinanceYesOrNo()) {
            return "Yes";
        }
        else {
            return "No";
        }

    }

    //when we get the total price
    //computed values based on rules
    //total price = salesTax + recordingFee + processingFee + Vehicle.price
    @Override
    public double getTotalPrice() {
        return salesTax + recordingFee + processingFee + getVehicleSold().price;
    }

    //ALL LOANS: 0.0425 for 48 months (4yrs) if  10,000+
    //0.0525 for 24 months (2yrs) if less 10,000
    //annuity formula monthly payment for a vehicle based on a fixed-rate loan formula
    @Override
    public double getMonthlyPayment() {
        double loan1 = 0.0425 / 12;
        double loan2 = 0.0525 / 12;

        if (isFinanceYesOrNo()) {
            if (getVehicleSold().getPrice() >= 10000) {
                //annuity in java, price * interest rate, math pow the first interest rate for 48 months
                //else, price * interest rate, * mathpow the second loan interest rate for 24 months
                double numerator = (getVehicleSold().getPrice() * loan1) * Math.pow(1 + loan1, 48);
                double denominator = Math.pow(1 + loan1, 48)-1;
                return (numerator / denominator);
            }
            else {
                double numerator = (getVehicleSold().getPrice() * loan2) * Math.pow(1 + loan2, 24);
                double denominator = Math.pow(1 + loan2, 24)-1;
                return (numerator / denominator);
            }
        }
        else {
            return 0;
        }
    }
}
