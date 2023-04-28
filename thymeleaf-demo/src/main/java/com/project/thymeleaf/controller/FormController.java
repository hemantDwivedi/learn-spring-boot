package com.project.thymeleaf.controller;

import com.project.thymeleaf.model.UserForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    // handler method to handle user registration page request
    @GetMapping("/user-registration")
    public String userRegistrationPage(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register-form";
    }

    // handler method to handle user  registration form submit request

    @PostMapping("/register/save")
    public String submitForm(Model model,
                             @ModelAttribute("userForm") UserForm userForm){
        model.addAttribute("userForm", userForm);
        return "success";
    }
}
