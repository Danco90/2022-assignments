package com.daniele.project.morgan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestGreaterCommodDivisor
{
    @Test
    @DisplayName("Test Greater Common Divisor among two numbers")
    void test_CalcGCD()
    {
        Assertions.assertAll(
                () -> Assertions.assertEquals(10, new GreaterCommonDivisor().calcGCD(10,100)));
    }

    @Test
    @DisplayName("Test Least Common Multiple among two numbers")
    void test_calcLCM()
    {
        Assertions.assertAll(
                () -> Assertions.assertEquals(100, new GreaterCommonDivisor().calcLCM(10,100)));
    }
}
