package com.daniele.project.cigniti;

import com.daniele.project.leetcode.Matrix2DSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestReviewsGroups
{
    @Test
    @DisplayName("Test method 1")
    void test_method1() {

        List<Reviews> reviewsList= List.of(
                new Reviews("1", "[\"group1\",\"group2\"]", "[\"air\",\"Speed\"]", "2021-01-01 05:32:44"),
                new Reviews("2", "[\"group1\"]", "[\"Air\",\"quality\"]", "2021-01-07 09:32:44"),
                new Reviews("3", "[\"group3\"]", "[\"air\",\"blades\"]", "2021-01-07 01:32:24"));

//        List<Reviews> reviewsList= new ArrayList<>();
//        reviewsList = Stream.of(new Reviews("1", "[\"group1\",\"group2\"]", "[\"air\",\"Speed\"]", "2021-01-01 05:32:44"),
//                        new Reviews("2", "[\"group1\"]", "[\"Air\",\"quality\"]", "2021-01-07 09:32:44"),
//                        new Reviews("3", "[\"group3\"]", "[\"air\",\"blades\"]", "2021-01-07 01:32:24"))
//                .collect(Collectors.toList());
       // Assertions.assertAll(
         //       () -> Assertions.assertEquals("", new ReviewsGroups()
           //             .groupBy_Date(reviewsList)));
    }
}
