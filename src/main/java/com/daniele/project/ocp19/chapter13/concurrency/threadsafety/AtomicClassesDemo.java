package com.daniele.project.ocp19.chapter13.concurrency.threadsafety;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicClassesDemo
{
    public static void main(String[] args)
    {
        ExecutorService service = Executors.newFixedThreadPool(20);//20 threads
        try
        {
            SheepManagerSafe manager = new SheepManagerSafe();
            //Rece condition - unexpected result of two tasks executing at the same time
            for(int i=0; i<10; i++) // 10 tasks submitted
                service.submit(() ->
                        manager.incrementAndReport());
            //Example of possible outputs
            //2 1 3 4 5 6 7 8 9 10
            //4 2 6 1 5 7 3 8 9 10 Order is not guaranteed
            //3 2 4 1 5 6 7 8 9 10 though, the numbers 1 through 10 will always be printed!

        } finally {
            service.shutdown(); //Initiates an orderly shutdown in which previously
            // submitted tasks are executed, but no new tasks will be accepted.
            // Invocation has no additional effect if already shut down.
        }
    }
}

class SheepManagerSafe
{
    //private int sheepCount = 0;
    private AtomicInteger sheepCount = new AtomicInteger(0);
    void incrementAndReport()
    {
        System.out.print((sheepCount.incrementAndGet())+" ");
    }
}

