package com.zcr.c005.wiringbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WiringBeanMain1 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student1 student1 = (Student1) context.getBean("student1");
        System.out.println(student1.toString());
        School1 s1 =(School1)context.getBean("school1");
        System.out.println(s1.toString());



    }
}
