package com.project.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.thymeleaf.model.User;

@Controller
public class UserController {
    @GetMapping("/variable-expression")
    public String variableExpression(Model model){
        User user = new User("hemant", "hemant@gmail.com", "admin", "male");
        model.addAttribute("user", user);
        return "variable-expression";
    }

    // handler method to handle selection expression
    @GetMapping("/selection-expression")
    public String selectionExpression(Model model){
        User user = new User("hemant", "hemant@gmail.com", "admin", "male");
        model.addAttribute("user", user);
        return "selection-expression";
    }

    // handler method to handle message expression request
    @GetMapping("/message-expression")
    public String messageExpression(){
        return"message-expression";
    }

    // handler method to handle Link expression
    @GetMapping("/link-expression")
    public String linkExpression(Model model){
        model.addAttribute("id", 1);
        return "link-expression";
    }

    // handler method to handle fragement expression
    @GetMapping("/fragement-expression")
    public String fragementExpression(){
        return "fragement-expression";
    }

    @GetMapping("/users")
    public String users(Model model){
        User admin = new User("Hemant", "hemant@gmail.com", "ADMIN", "Male");
        User user = new User("Hello", "hello@gmail.com", "USER", "Female");
        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(user);
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/if-unless")
    public String ifUnless(Model model){
        User admin = new User("Hemant", "hemant@gmail.com", "ADMIN", "Male");
        User user = new User("Hello", "hello@gmail.com", "USER", "Female");
        List<User> users = new ArrayList<>();
        users.add(admin);
        users.add(user);
        model.addAttribute("users", users);
        return "if-unless";
    }

    @GetMapping("/switch-case")
    public String switchCase(Model model){
        User admin = new User("Hemant", "hemant@gmail.com", "ADMIN", "Male");
        model.addAttribute("user", admin);
        return "switch-case";
    }
}
