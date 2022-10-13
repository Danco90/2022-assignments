package com.daniele.project.codewars;

public class BrilliantClerk
{
    public boolean serveQueue(int[] ints)
    {   //25, 25, 50, 50, 25, 25, 25, 100, 75        
        int changesBalance = 0;   //  changesBalance :

        if(ints.length == 0)
        {   return false; }
        else
        {
           for(int i=0; i< ints.length; i++)
           {   int occurrences = ints[i]/25;//  occurrences : 1
               if( occurrences == 1)
               {   changesBalance += occurrences;  continue; }
               else
               {    int changes = occurrences - 1;// 1 is the unit of 1 ticket price

                    if(changesBalance < changes )
                       return false;
                    else changesBalance -= changes;
               }
           }
           return true;
        }
    }
}
