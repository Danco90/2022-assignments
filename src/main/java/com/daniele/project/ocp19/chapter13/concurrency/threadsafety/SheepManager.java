package com.daniele.project.ocp19.chapter13.concurrency.threadsafety;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManager
{
    //private int sheepCount = 0;
    private volatile int sheepCount = 0;//volatile alone could still result in number being missed
    private void incrementAndReport()
    {
        //Lack of thread synchronization : both thread reand and write the same values
        // causing the two ++sheepCount operations to be lost.
        System.out.print((++sheepCount)+" ");//PROBLEM occurs when
        // two threads both execute the right side of the expression,
        // reading the "old" value before either thread writes the "new" value
        // the two assignments become redundant (assign the same new value)

        //NB: the increment operator ++ is NOT thread-safe
        // ,even when volatile is used

    }
    public static void main(String[] args)
    {
        ExecutorService service = Executors.newFixedThreadPool(20);//20 threads
        try
        {
            SheepManager manager = new SheepManager();
            //Rece condition - unexpected result of two tasks executing at the same time
            for(int i=0; i<10; i++) // 10 tasks submitted
                service.submit(() ->
                        manager.incrementAndReport());
            //Example of possible outputs
            //1 2 3 4 5 6 7 8 9 10
            //4 1 5 2 3 6 7 8 9 10 Order is not guaranteed
            //1 9 8 7 3 6 6 2 4 5  worse yet, it might print some number twice!

            //Other output with volatile alone
            //2 3 1 4 5 6 7 8 9 10
            //2 6 1 7 5 3 2 9 4 8 still results in number being missed such as 10

        } finally {
            service.shutdown(); //Initiates an orderly shutdown in which previously
            // submitted tasks are executed, but no new tasks will be accepted.
            // Invocation has no additional effect if already shut down.
        }
    }
}
