package com.daniele.project.citi;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestMyDemo
{

    @Test
    @DisplayName("Create a method which will return student collection for a given department id")
    void test_myMethod1()
    {
        List<Student> myList = Stream.of(
        new Student(  1,"Abbey",100,"COMPUTER","abbey@email.com"),

        new Student(       2,"Bob",200,"AEROSPACE","bob@email.com" ),

        new Student(   3, "Charlie",100,"COMPUTER","charlie@email.com"),

        new Student(      4,"Don",200,"AEROSPACE","don@email.com"),

        new Student(      5,"Emma",300,"ELEC","emma@email.com"),

        new Student(     6,"Fleming",100,"COMPUTER","fleming@email.com"),

        new Student(     7,"Gordon",300,"ELEC","gordon@email.com" ),

        new Student(     3,"Charlie",100,"COMPUTER","charlie@email.com" ),

        new Student(     5,"Emma",300,"ELEC","emma@email.com"))
                .collect(Collectors.toList());

        List<Student> myExpectedList = Stream.of(

                        new Student(      2,"Bob",200,"AEROSPACE","bob@email.com" ),
                        new Student(      4,"Don",200,"AEROSPACE","don@email.com") )
                .collect(Collectors.toList());

        Assertions.assertAll(
//                () -> Assertions.assertEquals(myExpectedList, new MyDemo().test_myMethod1(myList,200),"You went wrong"),
                () -> Assertions.assertEquals(3, new MyDemo().filterDuplicates(myList,100).size(),"You went wrong")

        );
    }


}
