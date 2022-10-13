package com.daniele.project.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReductionDemo
{
    public String reduceStream(String[] chars)
    {
        Stream<String> stream = Arrays.stream(chars);
          return stream.reduce("", (s, c) -> s + c);
    }

//    public String reduceStream(char[] chars)
//    {
//        Stream<Character> charStream = new String(chars).chars().mapToObj(i->(char)i);
//        return charStream.reduce("", (s, c) -> s + c);
//    }
}
