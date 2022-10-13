package com.daniele.project.tesco;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class CalculatoreUnitTest
{
    @Test
    @DisplayName("MY TEST")
    void givenABill_whenGetCahnge_thenArrayOfChangeIsReturned ()
    {
        //1    5    10   25    50    100  in Cents
        Assertions.assertAll(
//                () ->  Assertions.assertEquals(
//                        Arrays.toString(new int[]{1,0,0,0,0,4}),
//                        Arrays.toString(new VendingMachineChange().getChange("5", "0.99"))),
                () ->  Assertions.assertEquals(
                        Arrays.toString(new int[]{1,0,0,0,0,4}),
                        Arrays.toString(new VendingMachineChange().getChangePro2(new int[]{1,5,10,25,50,100},"5", "0.99")))
//                () ->  Assertions.assertEquals(
//                        Arrays.toString(new int[]{0,0,0,0,0,0}),
//                        Arrays.toString(new VendingMachineChange().getChange("5", "5"))),
//                () ->  Assertions.assertEquals(
//                        Arrays.toString(new int[]{1,0,0,0,0,2}),
//                        Arrays.toString(new VendingMachineChange().getChange("5", "2.99")))
//              () ->  Assertions.assertEquals(Arrays.toString(new int[]{1,0,0,1,0,4}), Arrays.toString(new VendingMachineChange().getChange("7", "2.73")))
        );
    }  
}
