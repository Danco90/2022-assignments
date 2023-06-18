package com.daniele.project.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Series {

    private int a, b, n;

    public Series(int a, int b, int n) {
        this.a = a;
        this.b = b;
        this.n = n;
    }
    
    public List<String> calcNthSeries() {
        List<String> results = new ArrayList<>();
        int left = (int) (a + Math.pow(2, 0) * b);
        for(int i=0; i<n; i++) {
            results.add(String.valueOf(recursivelySeries(left, i)));
        }
        return results;
    }

    public int recursivelySeries(int left, int exponent) {
        if(exponent == 0) {
           return left;
        } else {
            return recursivelySeries(left +  (int)(Math.pow(2, exponent) * b), --exponent);
        }
    }

    public String calcNthSeriesStr() {
        return calcNthSeries()
                .stream().collect(Collectors.joining(" "));
    }

    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String line = null;
            int count = 1;
            long startTime = System.currentTimeMillis();
            int q = 0;
            while((line =br.readLine())!=null)
            {
                if (count == 1) {
                    q = Integer.parseInt(line.trim());
                    count++;
                } else {
                    //do {
                String[] col = line.trim().split("\\s");
                int a = Integer.parseInt(col[0]);
                int b = Integer.parseInt(col[1]);
                int n = Integer.parseInt(col[2]);
                System.out.println(new Series(a, b, n).calcNthSeriesStr());
                count++;
                    //} while (count <= q);
                }
            }

            long endTime = System.currentTimeMillis();
            System.out.println(String.format("execution time: %1$d ms", (endTime - startTime)));
        }
    }
}
