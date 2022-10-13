package com.daniele.project.morgan;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestMultipleOfTwo
{
    @Test
    @DisplayName("Test Greater Multiple of two in a list")
    void givenAnInteger_whenAPowerOfTwoIsMet_thenTheLastMatchIsReturned()
    {
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, new MultipleOfTwo().findGreaterEven(12)));
    }

}
