package com.daniele.project.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;

public class TestMyDemo
{
    @Test
    @DisplayName("Test my method")
    void test_myMethod()
    {
        
    }

    @Test
    @DisplayName("Test calc average of integers")
    void test_calc_average_of_integers()
    {
        //1, 2, 3, 4, 5
        Assertions.assertEquals(3, new MyDemo().calc_average_of_integers(Arrays.asList(1,2,3,4,5)));
    }

    @Test
    @DisplayName("Test calc average from IntSummaryStatistics")
    void test_calc_average_from_IntSummaryStats()
    {
        Executable executable = () -> Assertions.assertEquals(3, new MyDemo().calc_average_from_IntSummaryStats(Arrays.asList(1, 2, 3, 4, 5)));
        Assertions.assertAll(
//                () -> Assertions.assertEquals(3, new MyDemo().calc_average_from_IntSummaryStats(Arrays.asList(1,2,3,4,5))),
                executable ,
                () -> Assertions.assertEquals(6.2, new MyDemo().calc_average_from_IntSummaryStats(Arrays.asList(1,2,7,8,13)))
        );



    }
}
