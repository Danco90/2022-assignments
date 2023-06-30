package com.daniele.project.ocp19.chapter13.concurrency.threadsafety;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class SheepManagerSynchronized
{
    private final Object herd = new Object();// even if not needed, the final
    // ensures that it is not reassigned after threads start using it
    private int sheepCount = 0;
    //private static int sheepCount = 0;
    void incrementAndReport()
    {
        synchronized (this/*SheepManagerSynchronized.class*//*herd*/) {
            System.out.print((++sheepCount) + " ");
        }
    }

    //static synchronization used if you need to order thread access
    // across all instances ather than a single instance
    /*static*/ synchronized void incrementAndReport2()
    {
        System.out.print((++sheepCount) + " ");
    }

    public static void main(String[] args)
    {
        ExecutorService service = Executors.newFixedThreadPool(20);//20 threads
        try
        {
            var manager = new SheepManagerSynchronized();
            //No more Race condition - expected result in order
            for (int i = 0; i < 10; i++) // 10 tasks submitted
            {   service.submit(() ->
                    manager.incrementAndReport());
            }
            //Example of possible outputs
            //1 2 3 4 5 6 7 8 9 10 Order is now guaranteed
           
        } finally {
            service.shutdown(); //Initiates an orderly shutdown in which previously
            // submitted tasks are executed, but no new tasks will be accepted.
            // Invocation has no additional effect if already shut down.
        }
    }
}
