package com.daniele.project.streams;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamPractice
{
    public double exercise2(List<Employee> list)
    {
        return list.stream()
                .mapToDouble(Employee::salary)
                .average()
                .getAsDouble();
//                .summaryStatistics()
//                .getAverage();
    }

    public record Employee(String name, String title, double salary)
    {


        public Employee (String name, String title){
           this(name, title, 0.0);
        }

        public Employee {
            Objects.requireNonNull(title);
            Objects.requireNonNull(salary);
        }
        
        @Override
        public String toString()
        {
            return "{" +
//                    "Employee{" +
                    "name='" + name + '\'' +
                    ", title='" + title + '\'' +
                    ", salary='" + salary + '\'' +
                    '}';
        }
    }
    /**
     * The task is to group an array of employee records into a data map organized by job title
     * @return
     */
    public String exercise1(List<Employee> employeeList)
    {    Map<String, List<Employee>> resultMap =
            employeeList.stream().collect(
            Collectors.groupingBy( Employee::title       
            ));
        return resultMap.toString();
    }
}
