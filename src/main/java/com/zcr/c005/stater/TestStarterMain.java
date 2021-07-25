package com.zcr.c005.stater;

import com.zcr.stater.ISchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class TestStarterMain {

    @Autowired
    public ISchool school1;

    public static void main(String[] args) {

        SpringApplication.run(TestStarterMain.class, args);
        System.out.println("===");

    }

    @Bean
    public void printInfo(){
        school1.ding();
    }

}
