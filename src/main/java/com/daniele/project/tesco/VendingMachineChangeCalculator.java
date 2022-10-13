package com.daniele.project.tesco;

public interface VendingMachineChangeCalculator
{
    /**
    *
     * *  @param amountInserted - Total amount the customer threw into the machine
    * @param price - The actual price of the selected item*
     *  * @return An array containing how many coins are needed from the corresponding denominations

     ** Available denominations: 1 cent, 5 cent, 10 cent, 25 cent, 50 cent, 1 dollar
   * Examples:
        *  getChange("5", "0.99") -> [1, 0, 0, 0, 0, 4]
        *  getChange("5", "5") -> [0, 0, 0, 0, 0, 0]
        */
    int[] getChange(String amountInserted, String price);

    int[] getChangePro(int[] denominations, String amountInserted, String price);

}
