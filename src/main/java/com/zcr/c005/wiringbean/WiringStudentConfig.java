package com.zcr.c005.wiringbean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WiringStudentConfig {

    @Bean
    public Student3 getStudent3(){
        return new Student3("第3种装配id","第3种装配id");
    }

    @Bean(name="school3")
    public School3 getSchool3(Student3 student3){

        return new School3("通过config-代码装配",student3);
    }
}
