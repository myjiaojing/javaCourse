package com.zcr.c005.wiringbean;

public class Student3 {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student3{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Student3(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
