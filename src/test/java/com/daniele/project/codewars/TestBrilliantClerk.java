package com.daniele.project.codewars;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class TestBrilliantClerk
{
    @Test
    @DisplayName("Test Bank clerk serving a queue")
    void test_serveQueue()
    {
        Executable executable  = () -> Assertions.assertEquals(true, new BrilliantClerk().serveQueue(new int[]{25, 25, 30}));
        Executable executable2 = () -> Assertions.assertEquals(false, new BrilliantClerk().serveQueue(new int[]{25, 100}));

        Assertions.assertAll(
                executable, executable2,
                () -> Assertions.assertEquals(false, new BrilliantClerk().serveQueue(new int[]{25, 25, 50, 50, 100})),
                () -> Assertions.assertEquals(false, new BrilliantClerk().serveQueue(new int[]{25, 25, 50, 50, 25, 25, 25, 100, 75}))
        );
    }
}
