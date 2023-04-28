package com.spring.core;

import org.springframework.stereotype.Component;

@Component("car")
public class Car implements Vehicle{
    public void move(){
        System.out.println("car is moving...");
    }
}
