package com.daniele.project.morgan;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GreaterCommonDivisor
{
    public int calcGCD(int n1, int n2)
    {
         int gcd = 1;
         for(int i=1; i<= n1 && i<= n2; i++)
         {
             if(n1%i == 0 && n2 %i ==0)
             {
                 gcd = i;
             }
         }
         return gcd;

    }

    public int calcLCM(int n1, int n2)
    {
       if(n1 == 0 || n2 ==0)
           return 0;

        Map<Integer, Integer> primeFactorsForNum1 = getPrimeFactors(n1);
        Map<Integer, Integer> primeFactorsForNum2 = getPrimeFactors(n2);

        Set<Integer> primeFactorsUnionSet = new HashSet<>(primeFactorsForNum1.keySet());
        primeFactorsUnionSet.addAll(primeFactorsForNum2.keySet());

        int lcm = 1;

        for (Integer primeFactor : primeFactorsUnionSet)
        {
            lcm *= Math.pow(primeFactor,
                    Math.max(primeFactorsForNum1.getOrDefault(primeFactor, 0),
                             primeFactorsForNum2.getOrDefault(primeFactor, 0)));
        }

        return lcm;

    }

    public static Map<Integer, Integer> getPrimeFactors(int number) {
        int absNumber = Math.abs(number);

        Map<Integer, Integer> primeFactorsMap = new HashMap<Integer, Integer>();

        for (int factor = 2; factor <= absNumber; factor++) {
            while (absNumber % factor == 0) {
                Integer power = primeFactorsMap.get(factor);
                if (power == null) {
                    power = 0;
                }
                primeFactorsMap.put(factor, power + 1);
                absNumber /= factor;
            }
        }

        return primeFactorsMap;
    }
}
