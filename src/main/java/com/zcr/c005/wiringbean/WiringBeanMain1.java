package com.zcr.c005.wiringbean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WiringBeanMain1 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");


        School1 s1 =(School1)context.getBean("school1");
        System.out.println(s1.toString());

        School2 s2 =(School2)context.getBean("school2");
        System.out.println(s2.toString());

        School3 s3 =(School3)context.getBean("school3");
        System.out.println(s3.toString());



    }
}
