package com.daniele.project.streams;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StringFormatter
{

    public String reformat(String s)
    {   //0 - 22 1985--324
        String[] array = s.split("-|\\s");// - or space
        String str = Arrays.stream(array)
                .collect(Collectors.joining(""));
        if(array.length%3 == 1 )
        {

            String [] array2 = str.substring(0, str.length() - 4).split("(?<=\\G...)");
            String [] array3 = str.substring(str.length() - 4, str.length()).split("(?<=\\G..)");
            return Arrays.stream(array2)
                    .collect(Collectors.joining("-")) +
                    "-" +
                    Arrays.stream(array3)
                            .collect(Collectors.joining("-"));
        }
        else
        {
            array = str.split("(?<=\\G...)");
            return Arrays.stream(array)
                    .collect(Collectors.joining("-"));
        }

        
    }
}
