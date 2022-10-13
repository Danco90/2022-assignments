package com.daniele.project.streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamPractice
{

     @Test
     @DisplayName("Test Average salary of all employee in the list")
     void test_exercise2()
     {
         StreamPractice.Employee employee1 = new StreamPractice.Employee("Matteo", "Tech Lead", 80000.0);
         StreamPractice.Employee employee2 = new StreamPractice.Employee("Daniele", "Project Manager", 55000.0);
         StreamPractice.Employee employee3 = new StreamPractice.Employee("Elio", "Tech Lead", 90000.0);
         StreamPractice.Employee employee4 = new StreamPractice.Employee("Andrea", "Software Architect",50000.0);
         List<StreamPractice.Employee> list = List.of(employee1, employee2, employee3, employee4);

         Assertions.assertAll(
                 () -> Assertions.assertEquals(68750.0, new StreamPractice().exercise2(list))
         );
     }

     @Test
     @DisplayName("Test Grouping by Employee's title")
     void test_exercise1()
     {
         StreamPractice.Employee employee1 = new StreamPractice.Employee("Matteo", "Tech Lead");
         StreamPractice.Employee employee2 = new StreamPractice.Employee("Daniele", "Project Manager");
         StreamPractice.Employee employee3 = new StreamPractice.Employee("Elio", "Tech Lead");
         StreamPractice.Employee employee4 = new StreamPractice.Employee("Andrea", "Software Architect");
         List<StreamPractice.Employee> list = List.of(employee1, employee2, employee3, employee4);

         List<StreamPractice.Employee> list1 = List.of(employee1, employee3);
         List<StreamPractice.Employee> list2 = List.of(employee2);
         List<StreamPractice.Employee> list3 = List.of(employee4);

         Map<String, List<StreamPractice.Employee>> map =
                 //Casual Implementation of Map
                 Map.of("Tech Lead",list1,
                     "Project Manager", list2,
                     "Software Architect", list3

                );

         Map<String, List<StreamPractice.Employee>> fakeLinkedHashMapashMap =
                 //Specific Implementation of Map, such as TreeMap, which keeps order of insertion and without which we get a random one from Map.of
                 new LinkedHashMap<>(
//                         Map.of(
//                                 "Tech Lead",list1,
//                                 "Project Manager", list2,
//                                 "Software Architect", list3
//                         )
                         Map.ofEntries(
                                 new AbstractMap.SimpleEntry<String, List<StreamPractice.Employee>>("Tech Lead",list1),
                                 new AbstractMap.SimpleEntry<String, List<StreamPractice.Employee>>("Project Manager", list2),
                                 new AbstractMap.SimpleEntry<String, List<StreamPractice.Employee>>("Software Architect", list3)
                         )
                 );

         Map<String, List<StreamPractice.Employee>> orderedMap = Stream.of(
                 new AbstractMap.SimpleEntry<>("Tech Lead",list1),
                 new AbstractMap.SimpleEntry<>("Project Manager", list2),
                 new AbstractMap.SimpleEntry<>("Software Architect", list3)
         ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

         Assertions.assertAll(
//                 () -> Assertions.assertEquals(
//                         "{Tech Lead=[{name='Matteo', title='Tech Lead'}, {name='Elio', title='Tech Lead'}], " +
//                                    "Project Manager=[{name='Daniele', title='Project Manager'}], " +
//                                    "Software Architect=[{name='Andrea', title='Software Architect'}]" +
//                                  "}", new StreamPractice().exercise1(list)),
                 () -> Assertions.assertEquals(orderedMap.toString(), new StreamPractice().exercise1(list))
         );
     }
}
