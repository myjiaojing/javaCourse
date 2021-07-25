package com.zcr.c005.wiringbean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class School2 {

    @Value("通过Component组件扫描")
    private String name;

    @Autowired
    private Student2 student2;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student2 getStudent2() {
        return student2;
    }

    public void setStudent2(Student2 student2) {
        this.student2 = student2;
    }

    @Override
    public String toString() {
        return "School2{" +
                "name='" + name + '\'' +
                ", student2=" + student2 +
                '}';
    }
}
