package com.project.restapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    // HTTP GET REQUEST
    @GetMapping("/greeting")
    public String helloWorld(){
        return "hello world";
    }
}
