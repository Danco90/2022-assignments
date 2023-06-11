package com.daniele.project.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSolution {

    @Test
    @DisplayName("Create a method which will validate an IP address")
    public void testMymethod1() {
        //final String FINAL_ZERO_TO_255 = "((\\d{1,2}|[01]\\d{1,2}|[0-2][0-4]\\d|25[0-5])\\.){3}(\\d{1,2}|[01]\\d{1,2}|[0-2][0-4]\\d|25[0-5])";
        final String PAT = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        final String FINAL_ZERO_TO_255 = "("+ PAT +"\\.){3}"+ PAT;
        Solution.MyRegex myRegex = new Solution().new MyRegex(FINAL_ZERO_TO_255);

        final String IP1 = "000.12.12.034";
        final String IP2 = "121.234.12.12";
        final String IP3 = "23.45.12.56";
        final String IP4 = "00.12.123.123123.123";
        final String IP5 = "122.23";
        final String IP6 = "Hello.IP";
        
        Assertions.assertAll(
                () -> Assertions.assertTrue(myRegex.validate(IP1)),
                () -> Assertions.assertTrue(myRegex.validate(IP2)),
                () -> Assertions.assertTrue(myRegex.validate(IP3)),
                () -> Assertions.assertFalse(myRegex.validate(IP4)),
                () -> Assertions.assertFalse(myRegex.validate(IP5)),
                () -> Assertions.assertFalse(myRegex.validate(IP6))
        );

        Assertions.assertAll(
                () -> Assertions.assertTrue(myRegex.validateOld(IP1)),
                () -> Assertions.assertTrue(myRegex.validateOld(IP2)),
                () -> Assertions.assertTrue(myRegex.validateOld(IP3)),
                () -> Assertions.assertTrue(myRegex.validateOld(IP4)),//true for 00.12.123.123123.123 as it does not check exact match but just if contains str
                () -> Assertions.assertFalse(myRegex.validateOld(IP5)),
                () -> Assertions.assertFalse(myRegex.validateOld(IP6))
        );
    }
}
