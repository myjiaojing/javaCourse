package com.zcr.c005.wiringbean;

public class Student1 {
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
        return "Student1{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
