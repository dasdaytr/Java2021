package com.example.JAVA.TASKS.Number13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class User {
    @Value("${program.student.firstName}")
    private String firstName;
    @Value("${program.student.lastName}")
    private String lastName;
    @Value("${program.student.group}")
    private String group;
    @PostConstruct
    public void a(){
        System.out.println(firstName+" "+ lastName + " " + group);
    }


}
