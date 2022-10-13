package com.daniele.project.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestMatrix2DSearch
{
    @Test
    @DisplayName("Search s 2D Matrix")
    void test_searchMatrix()
    {
        Assertions.assertAll(
                () -> Assertions.assertTrue(new Matrix2DSearch()
                        .searchMatrix(new int[][] {
                                 {1, 4, 7, 11,15},
                                 {2, 5, 8, 12,19},
                                 {3, 6, 9, 16,22},
                                 {10,13,14,17,24},
                                 {18,21,23,26,30}
                        }, 5)),
                () -> Assertions.assertTrue(new Matrix2DSearch()
                        .searchMatrix(new int[][] {
                                {1, 2, 3, 4, 5},
                                {6, 7, 8, 9, 10},
                                {11,12,13,14,15},
                                {16,17,18,19,20},
                                {21,22,23,24,25}
                        }, 15)),
                () -> Assertions.assertTrue(new Matrix2DSearch()
                        .searchMatrix(new int[][] {
                                {1, 2, 3, 4, 5},
                                {6, 7, 8, 9, 10},
                                {11,12,13,14,15},
                                {16,17,18,19,20},
                                {21,22,23,24,25}
                        }, 25)),
                                () -> Assertions.assertTrue(new Matrix2DSearch()
                        .searchMatrix(new int[][] {
                                {1, 2, 3, 4, 5},
                                {6, 7, 8, 9, 10},
                                {11,12,13,14,15},
                                {16,17,18,19,20},
                                {21,22,23,24,25}
                        }, 5)),
                () -> Assertions.assertTrue(new Matrix2DSearch()
                        .searchMatrix(new int[][] {
                                {-5}
                        }, -5)),
                () -> Assertions.assertTrue(new Matrix2DSearch()
                        .searchMatrix(new int[][] {
                                {1,2},{2,5}
                        }, 5)));
    }

}
