package com.zcr.c005.wiringbean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student2 {

    @Value("第2种装配id")
    private String id;
    @Value("第2种装配name")
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
        return "Student2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
