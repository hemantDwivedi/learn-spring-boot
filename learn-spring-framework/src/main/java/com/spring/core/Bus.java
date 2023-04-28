package com.spring.core;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("bus")
@Primary
public class Bus implements Vehicle{
    public void move(){
        System.out.println("bus is moving...");
    }
}
