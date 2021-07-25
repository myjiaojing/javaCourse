package com.zcr.c005.wiringbean;

public class School3 {

    private String name;

    private Student3 student3;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student3 getStudent3() {
        return student3;
    }

    public void setStudent3(Student3 student3) {
        this.student3 = student3;
    }

    @Override
    public String toString() {
        return "School3{" +
                "name='" + name + '\'' +
                ", student3=" + student3 +
                '}';
    }

    public School3(String name, Student3 student3) {
        this.name = name;
        this.student3 = student3;
    }
}
