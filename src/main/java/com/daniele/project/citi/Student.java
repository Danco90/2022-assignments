package com.daniele.project.citi;

import java.util.Objects;

public class Student
{
    private int id;
    private String name;
    private int departmentID;
    private String departmentName;
    private String emailID;

    public Student(int id, String name, int departmentID, String departmentName, String emailID)
    {
        this.id = id;
        this.name = name;
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.emailID = emailID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && departmentID == student.departmentID && Objects.equals(name, student.name) && Objects.equals(departmentName, student.departmentName) && Objects.equals(emailID, student.emailID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, departmentID, departmentName, emailID);
    }

    public int getDepartmentID() {
        return departmentID;
    }
}
