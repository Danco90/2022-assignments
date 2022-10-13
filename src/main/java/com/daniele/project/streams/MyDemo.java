package com.daniele.project.streams;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;

public class MyDemo
{
    public double calc_average_of_integers(List<Integer> list)
    {   OptionalDouble res = list.stream()
                .mapToInt( i -> i)
                .average();
        return res.getAsDouble();
    }

    public double calc_average_from_IntSummaryStats(List<Integer> list)
    {   IntSummaryStatistics stats = list.stream()
                .mapToInt( i -> i)
                .summaryStatistics();
        return stats.getAverage();
    }
}
