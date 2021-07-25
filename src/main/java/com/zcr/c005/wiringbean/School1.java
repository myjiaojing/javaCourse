package com.zcr.c005.wiringbean;

public class School1 {

    private String name;

    private Student1 student1;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student1 getStudent1() {
        return student1;
    }

    public void setStudent1(Student1 student1) {
        this.student1 = student1;
    }

    @Override
    public String toString() {
        return "School1{" +
                "name='" + name + '\'' +
                ", student1=" + student1 +
                '}';
    }
}
