package com.daniele.project.citi;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MyDemo
{
    public List<Student> test_myMethod1(Collection<Student> myList, int departmentID)
    {
         return myList.stream()
                 .filter(s -> s.getDepartmentID() == departmentID)
                 .collect(Collectors.toList());


    }

    public Set<Student> filterDuplicates(Collection<Student> myList, int departmentID)
    {
        return myList.stream()
                .filter(s -> s.getDepartmentID() == departmentID)
                .collect(Collectors.toSet());


    }
}
