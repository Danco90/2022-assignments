package com.daniele.project.morgan;

public class MultipleOfTwo
{
    public int findGreaterEven(int num)
    {
         for(int i=2; i<num; i++)
         {
             if (num % i == 0)
                 return i;
         }
         return 1;
    }
}
