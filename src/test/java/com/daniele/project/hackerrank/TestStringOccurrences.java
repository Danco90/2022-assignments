package com.daniele.project.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestStringOccurrences {

    @Test
    @DisplayName("Create a method which count occurrences of each alphabets inside a string")
    public void testTransform() {

        final String testCase0 = "3";
        final String testCase1 = "aaaa";
        final String testCase2 = "aaabbc";
        final String testCase3 = "aabacbbc";
        StringAndOccurrences demo = new StringAndOccurrences();
        Assertions.assertAll(
                () -> Assertions.assertEquals("",demo.transform(testCase0)),
                () -> Assertions.assertEquals("4",demo.transform(testCase1)),
                () -> Assertions.assertEquals("321",demo.transform(testCase2)),
                () -> Assertions.assertEquals("332",demo.transform(testCase3))
        );

    }
}
