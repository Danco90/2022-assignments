package com.daniele.project.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestStringFormatter
{
    @Test
    @DisplayName(" Test String re-formatted as per patterns ")
    void test_reformat()
    {
        Assertions.assertAll(
                () ->   Assertions.assertEquals("022-198-53-24", new StringFormatter().reformat("0 - 22 1985--324")),
                () ->   Assertions.assertEquals("004-448-555-583-61", new StringFormatter().reformat("00-44 48 5555 8361"))
        );
    }
}
