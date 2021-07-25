package com.zcr.stater;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SchoolAutoConfigure {


    @Bean
    public List<Student> getStudentList(){
        List students = new ArrayList();
        students.add(new Student(1,"第一个学生"));
        students.add(new Student(2,"第二个学生"));
        students.add(new Student(3,"第三个学生"));


        return students;
    }

    @Bean
    public Klass getKlass(List<Student> students){

        return new Klass(students);
    }

    @Bean
    public School getSchool(Klass klass){
        return new School(klass,new Student(5,"test1"));
    }

}
