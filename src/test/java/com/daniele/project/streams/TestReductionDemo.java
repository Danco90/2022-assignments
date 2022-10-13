package com.daniele.project.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestReductionDemo
{
    @Test()
    @DisplayName("Test Stream Reduction with reduce()")
    void test_reduceStream()
    {
        Assertions.assertAll(
                () -> Assertions.assertEquals("wolf", new ReductionDemo().reduceStream(new String[] {"w","o","l","f"}))
        );
    }
}
