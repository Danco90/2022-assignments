package com.daniele.project.ocp19.chapter13.concurrency.parallerlstreams;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamsDemo
{
    public static void main(String[] args)
    {
          Collection<Integer> collection = List.of(1,2);

          Stream<Integer> p1 =  collection.stream().parallel();
          Stream<Integer> p2 =  collection.parallelStream();
          // Stream interface includes isParalle() to test if
          // the instance of a stream supports parallel processing.
          // Some operations preserve the parallel attribute, while others do not.

          // Performing a Parallel Decomposition

          // Using serial stream Vs Parallel stream
          long start = System.currentTimeMillis();
          List.of(1,2,3,4,5)
                  .parallelStream()
                  .map(w -> doWork(w))
                  .forEach(s -> System.out.println(s + " "));
                  // results are nor ordered or predictable for parallel

          System.out.println();
          var timeTaken = (System.currentTimeMillis() - start) / 1000;
          System.out.println("Time: "+timeTaken);// For serial Result is predictable and 25
          //whereas for parallel it might be unpredictable such as 5
          // or 10 (My macbook is dual core) ones because there are not enough CPUs
          // Using parallel stream

          System.out.println();
          // Ordering Results when you are not sure if it is serial or parallel stream
          start = System.currentTimeMillis();
          List.of(1,2,3,4,5)
                .parallelStream()
                .map(w -> doWork(w))
                .forEachOrdered(s -> System.out.println(s + " "));
          // results are now ordered 

          System.out.println();
          timeTaken = (System.currentTimeMillis() - start) / 1000;
          System.out.println("Time: "+timeTaken);// For serial Result is predictable and 25

          // Processing Parallel Reductions

          // Performing Order-Based Tasks
        System.out.print(List.of(1,2,3,4,5,6)
                .parallelStream()
                .findAny()
                .get());//neither serial or parallel is guaranteed to return the first value
        //however, the serial stream often does return 1

        //Rule: for operations that consider order, such as findFirst(), limit() or skip()
        // order is still preserved, but performance may suffer on a parallel stream

        //Creating Unordered Streams
        // It odes not reorde elements but instructs JVM
        // to ignore order in an order-based stream operation
        List.of(1,2,3,4,5,6).stream().unordered();//NO effect to serial

        //It does improve performance, though, on a parallelStream
        List.of(1,2,3,4,5,6).stream().unordered().parallel();

        


        
    }

    private static int doWork(int input)
    {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) { }
        return input;
    }
}
