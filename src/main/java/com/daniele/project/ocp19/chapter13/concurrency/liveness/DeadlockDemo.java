package com.daniele.project.ocp19.chapter13.concurrency.liveness;

import java.util.concurrent.Executors;

public class DeadlockDemo
{
    public static void main(String[] args)
    {
        // Create participants and resources
        var foxy = new Fox("Foxy");
        var tails = new Fox("Tails");
        var food = new Food();
        var water = new Water();
        // Process data
        var service = Executors.newScheduledThreadPool(10);
        try {
            service.submit(() ->
                    foxy.eatAndDrink(food, water));
            service.submit(() ->
                    tails.drinkAndEat(food, water));
        } finally {
           service.shutdown();
        }
    }
}

class Food { }
class Water { }
record Fox(String name)
{
   void eatAndDrink(Food food, Water water)
   {
       synchronized(food) {
           System.out.println(name() + " Got Food!");
           move();
           synchronized(water) {
               System.out.println(name() + " Got Water!");
           }
       }
   }

    void drinkAndEat(Food food, Water water)
    {
        synchronized(water) {
            System.out.println(name() + " Got Water!");
            move();
            synchronized(food) {
                System.out.println(name() + " Got Food!");
            }
        }
    }

    void move()
    {
        try
        {
           Thread.sleep(100);
        } catch(InterruptedException e) {

        }
    }
}
