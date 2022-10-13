package com.daniele.project.tesco;

import com.daniele.project.tesco.VendingMachineChangeCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class VendingMachineChange implements VendingMachineChangeCalculator
{

    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String...args)
    {
        VendingMachineChangeCalculator vncc = new VendingMachineChange();
        System.out.println("Start");
        //0.01 0.05  0.1  0.25  0.5  1    in Dollars
        //1    5    10   25    50    100  in Cents
        int[] denominations = {1,5,10,25,50,100} ;//in cents
       // System.out.println(Arrays.toString(vncc.getChangePro(denominations, "5","0.99")));
       // System.out.println(Arrays.toString(vncc.getChangePro(denominations, "5","5")));
       // System.out.println(Arrays.toString(vncc.getChangePro(denominations,"5","2.80")));
        System.out.println(Arrays.toString(vncc.getChangePro(denominations,"7","2.73")));//[1, 0, 0, 1, 0, 4]
    }


    public int[] getChangePro(int[] denominations, String amountInserted, String price)
    {   int[] results = new int[denominations.length];
        double priceD = Double.parseDouble(price);
        double amountInsertedD = Double.parseDouble(amountInserted);
        double offSetD = ((amountInsertedD - priceD) *100);//convert in cents //
        int offSet = new BigDecimal(offSetD).setScale(2, RoundingMode.HALF_UP).intValue();
        
        for(int i=results.length-1; i>=0; i--)
        {    results[i] = offSet / denominations[i];
            if(offSet % denominations[i] == 0)
                return results;
            else
                offSet = offSet % denominations[i];
        }
        return results;
    }

    public int[] getChangePro2(int[] denominations, String amountInserted, String price)
    {   int[] results = new int[denominations.length];
        double priceD = Double.parseDouble(price);
        double amountInsertedD = Double.parseDouble(amountInserted);
        double offSetD = ((amountInsertedD - priceD) *100);//convert in cents //
        int offSet = new BigDecimal(offSetD).setScale(2, RoundingMode.HALF_UP).intValue();

        for(int i=results.length-1; i>=0; i--)
        {    while(offSet >= 0)
            {
                if(offSet >= 100)
                {
                    offSet-=-100;
                    results[i]=results[i]+1;
                    continue;
                }
                if(offSet >= 50)
                {
                    offSet-=-50;
                    results[i]=results[i]+1;
                    continue;
                }
                if(offSet >= 25)
                {
                    offSet-=-25;
                    results[i]=results[i]+1;
                    continue;
                }
                if(offSet >= 10)
                {
                    offSet-=-10;
                    results[i]=results[i]+1;
                    continue;
                }
                if(offSet >= 5)
                {
                    offSet-=-5;
                    results[i]=results[i]+1;
                    continue;
                }
                if(offSet >= 1)
                {
                    offSet-=-1;
                    results[i]=results[i]+1;
                    continue;
                }
            }
        }
        return results;
    }


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
    public int[] getChange(String amountInserted, String price)
    {
        //getChange("5", "0.99") -> [1, 0, 0, 0, 0, 4]
        double priceD = Double.parseDouble(price);
        double offSet =   Double.parseDouble(amountInserted) - priceD ;
        BigDecimal bdOffSet = new BigDecimal(offSet).setScale(2, RoundingMode.HALF_UP);
        //1 cent, 5 cent, 10 cent, 25 cent, 50 cent, 1 dollar
        //1/10 cent, 1/5 cent, 10 cent, 25 cent, 50 cent, 1 dollar
        //0.01 0.05 0.1 0.25 0.5 1    in Dollars
        int [] results = new int[6];
        while(offSet > 0.0)
        {
            if(offSet/1 != 0)
            {   results[5] = (int) (offSet/1);
                offSet-= results[5];
                offSet = round(offSet, RoundingMode.HALF_UP);
            }

            if(offSet/0.50 != 0)
            {   results[4] = (int) (offSet / 0.50);
                offSet-= results[4];
                offSet = round(offSet, RoundingMode.HALF_UP);
            }

            if(offSet/0.25 != 0)
            {   results[3] = (int) (offSet / 0.25);
                offSet-= results[3];
                offSet = round(offSet, RoundingMode.HALF_UP);
            }

            if(offSet/0.10 != 0)
            {   results[2] = (int) (offSet / 0.10);
                offSet-=results[2];
                offSet = round(offSet, RoundingMode.HALF_UP);
            }

            if(offSet/0.05 != 0)
            {   results[1] = (int) (offSet / 0.05);
                offSet-= results[1];
                offSet = round(offSet, RoundingMode.HALF_UP);
            }

             if(offSet/0.01 != 0 )
            {   results[0] = (int) (offSet / 0.01);
                offSet-= results[0];
                offSet = round (offSet, RoundingMode.HALF_UP);
            }

        }
        return results;
    }

    private double round (double num, RoundingMode mode)
    {
        return new BigDecimal(num).setScale(2, mode).doubleValue();
    }
}
