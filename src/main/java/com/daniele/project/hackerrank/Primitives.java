package com.daniele.project.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Primitives {

    public String testPrimitives(String input) {
        final byte MIN_BYTE = (byte)(Math.pow(2, 7));
        final short MIN_SHORT = (short)(Math.pow(2, 15));
        final int MAX_INT = (int) (Math.pow(2, 31));
        final long MAX_LONG = (long) (Math.pow(2, 63));
        StringBuilder sb = new StringBuilder();
        try{
            long i = Long.parseLong(input);
            if (i >= MIN_BYTE + 1 && i <= -MIN_BYTE -1) {
                sb.append(String.format("%d can be fitted in: ", i));
                sb.append("byte, short, int, long");

            } else if (i >= MIN_SHORT + 1 && i <= -MIN_SHORT -1) {
                sb.append(String.format("%d can be fitted in: ", i));
                sb.append("short, int, long");
            } else if (i >= -MAX_INT + 1 && i <= MAX_INT ) {
                sb.append(String.format("%d can be fitted in: ", i));
                sb.append("int, long");
            } else {
                sb.append(String.format("%d can be fitted in: ", i));
                sb.append("long");
            }
        } catch (Exception ex) {
            sb.append(String.format("%1$s can't be fitted anywhere.", input));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        final byte MIN_BYTE = (byte)(Math.pow(2, 7));
        final short MIN_SHORT = (short)(Math.pow(2, 15));
        final int MAX_INT = (int) (Math.pow(2, 31));
        final long MAX_LONG = (long) (Math.pow(2, 63));
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in)))
        {
            String line = null;
            int count=1;
            long T=0;
            while((line = br.readLine()) !=null) {
            if(count==1){
                T = Long.parseLong(line);
                count++;
            } else {
                try
                { long n = Long.parseLong(line);
                    if(n >= MIN_BYTE + 1 && n <= -MIN_BYTE -1)
                    {
                        System.out.println(String.format("%d can be fitted in:", n));
                        System.out.println(String.format("* byte"));
                        System.out.println(String.format("* short"));
                        System.out.println(String.format("* int"));
                        System.out.println(String.format("* long"));
                    } else if (n >= MIN_SHORT + 1 && n <= -MIN_SHORT -1) {
                        System.out.println(String.format("%d can be fitted in:", n));
                        System.out.println(String.format("* byte"));
                        System.out.println(String.format("* short"));
                        System.out.println(String.format("* int"));
                        System.out.println(String.format("* long"));
                    } else if (n >= -MAX_INT + 1 && n <= MAX_INT ) {
                        System.out.println(String.format("%d can be fitted in:", n));
                        System.out.println(String.format("* int"));
                        System.out.println(String.format("* long"));
                    } else if (n >= -MAX_LONG + 1 && n <= MAX_LONG) {
                        System.out.println(String.format("%d can be fitted in:", n));
                        System.out.println(String.format("* long"));
                    }
                } catch(Exception ex) {
                    System.out.println(String.format("%d can't be fitted."));
                }
                count++;
            }
        }
        }
    }
}
