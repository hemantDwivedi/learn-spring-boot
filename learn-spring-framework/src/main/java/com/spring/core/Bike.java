package com.spring.core;

import org.springframework.stereotype.Component;

@Component("bike")
public class Bike implements Vehicle{
    public void move(){
        System.out.println("bike is moving...");
    }
}
