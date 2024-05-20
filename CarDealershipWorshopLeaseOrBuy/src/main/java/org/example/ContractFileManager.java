package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class ContractFileManager {
    public static void vehicleContract (Contract contract) {
        //add decimal format, try catch and writer
        //add new contracts csv
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        try (FileWriter writer = new FileWriter("src/main/resources/Contracts.csv", true)) {
            if (contract instanceof SalesContract) {
                writer.write("SALE | " + contract.getDateOfContract() + "| " + contract.getCustomerName() + "\n");
                writer.write("  " + contract.getVehicleSold().toString()+"\n");
                writer.write("  " + ((SalesContract) contract).getSalesTax() + "|" + ((SalesContract) contract).getRecordingFee() + "|" + ((SalesContract) contract).getProcessingFee()+ "|" + contract.getTotalPrice() + "|" + ((SalesContract) contract).isFinanceYesOrNo() + "|"  + decimalFormat.format(contract.getMonthlyPayment()) + "\n");
            }
            else if (contract instanceof LeaseContract) {
                writer.write("LEASE | " + contract.getDateOfContract() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "\n");
                writer.write("  " + contract.getVehicleSold().toString() + "\n");
                writer.write("  " + ((LeaseContract) contract).getExpectedEndingValue() + "|" + ((LeaseContract) contract).getLeaseFee() + "|" + contract.getTotalPrice() + "|" + decimalFormat.format(contract.getMonthlyPayment()) + "\n");
            }
            else {
                writer.write("N/A Contract Information");
            }
        }
        catch (IOException exception) {
            System.out.println("ERROR" + exception.getMessage());
        }
    }
}
