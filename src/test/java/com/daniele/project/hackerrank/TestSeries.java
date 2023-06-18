package com.daniele.project.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestSeries {

    @Test
    @DisplayName("Print the series corresponding to the given a,b and n values as a single line of n space-separated integers")
    public void testSeries() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(
                        "2 6 14 30 62 126 254 510 1022 2046",
                        new Series(0, 2, 10).calcNthSeriesStr()),
                () -> Assertions.assertEquals(
                        "8 14 26 50 98",
                        new Series(5, 3, 5).calcNthSeriesStr()),
                () -> Assertions.assertEquals(
                        "6 12 24",
                        new Series(3, 3, 3).calcNthSeriesStr()),
                () -> Assertions.assertEquals(
                        "0 0 0 0 0",
                        new Series(0, 0, 5).calcNthSeriesStr()),
                () -> Assertions.assertEquals(
                        "12 24 48 96 192 384 768 1536 3072 6144",
                        new Series(6, 6, 10).calcNthSeriesStr()),
                () -> Assertions.assertEquals(
                        "2 6 14 30 62 126 254 510 1022 2046",
                        new Series(0, 2, 10).calcNthSeriesStr()),
                () -> Assertions.assertEquals(
                        "8 14 26 50 98",
                        new Series(5, 3, 5).calcNthSeriesStr())
        );
    }
}
