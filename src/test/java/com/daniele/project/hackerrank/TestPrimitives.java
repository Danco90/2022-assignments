package com.daniele.project.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestPrimitives {
    @Test
    @DisplayName("Test primitives used to hold integer values (byte, short, int, and long)")
    public void testPrimitives() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(
                        "-150 can be fitted in: short, int, long",
                                 new Primitives().testPrimitives("-150")),
                () -> Assertions.assertEquals(
                        "150000 can be fitted in: int, long",
                                   new Primitives().testPrimitives("150000")),
                () -> Assertions.assertEquals(
                        "1500000000 can be fitted in: int, long",
                        new Primitives().testPrimitives("1500000000")),
                () -> Assertions.assertEquals(
                        "213333333333333333333333333333333333 can't be fitted anywhere.",
                        new Primitives().testPrimitives("213333333333333333333333333333333333")),
                () -> Assertions.assertEquals(
                        "-100000000000000 can be fitted in: long",
                        new Primitives().testPrimitives("-100000000000000")),
                () -> Assertions.assertEquals(
                        "9223372036854775808 can't be fitted anywhere.",
                        new Primitives().testPrimitives("9223372036854775808")),
                () -> Assertions.assertEquals(
                        "12222222222222222222222222222222222222222221 can't be fitted anywhere.",
                        new Primitives().testPrimitives("12222222222222222222222222222222222222222221")),
                () -> Assertions.assertEquals(
                        "-9223372036854775808 can be fitted in: long",
                        new Primitives().testPrimitives("-9223372036854775808")),
                () -> Assertions.assertEquals(
                        "-9223372036854775807 can be fitted in: long",
                        new Primitives().testPrimitives("-9223372036854775807"))
        );

    }
}
