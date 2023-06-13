package com.daniele.project.hackerrank;

import java.util.Scanner;
import java.util.stream.Collectors;

public class StringAndOccurrences {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);
        StringAndOccurrences sol = new StringAndOccurrences();
        int attempts=10;
        while(scan.hasNext()== true /*&& attempts>0*/){
            String inLine = scan.nextLine();
            //if(inLine.length()>0 && inLine.length()<1_000_000){
            String output = sol.transform(inLine);
            if(!output.isEmpty()) { System.out.println(output); };
            attempts--;
            // }
        }
    }

    public String transform(String input) {
        return input.chars().mapToObj(c -> (char) c).filter(c -> Character.isLetter(c))
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .map(e -> e.getValue().toString()).collect(Collectors.joining());
    }
}
