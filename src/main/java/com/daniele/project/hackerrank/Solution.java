package com.daniele.project.hackerrank;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    class MyRegex {
        private final String PATTERN;

        MyRegex(final String PATTERN) {
            this.PATTERN = PATTERN;
        }

        public boolean validate(final String INPUT) {
            return INPUT.matches(PATTERN);
        }

        //It does not work properly for case  00.12.123.123123.123
        public boolean validateOld(final String INPUT) {
            Pattern pattern = Pattern.compile(PATTERN, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(INPUT);
            boolean matchFound = matcher.find();
            return matchFound;
        }
    }

    public static void main(String[] args) throws IOException{
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scan = new Scanner(System.in);

        final String PAT = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
        final String FINALZEROTO255 = new StringBuilder().append("(").append(PAT)
                .append("\\.){3}").append(PAT).toString();

       Solution.MyRegex myRegex = new Solution().new MyRegex(FINALZEROTO255);

        while(scan.hasNext() == true) {
          String str = scan.nextLine();
          System.out.println(myRegex.validate(str));
        }
        scan.close();
        /*
        000.12.12.034
        121.234.12.12
        23.45.12.56
        00.12.123.123123.123
        122.23
        Hello.IP
        */
    }
}