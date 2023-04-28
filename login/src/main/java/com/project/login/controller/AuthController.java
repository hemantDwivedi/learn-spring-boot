package com.project.login.controller;

import com.project.login.dto.UserDto;
import com.project.login.entity.User;
import com.project.login.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class AuthController {

    private UserService userService;

    // handler to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    // handler method to handle registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User user = userService.findUserByEmail(userDto.getEmail());
        if(user != null){
            result.rejectValue("email", null, "There is an already account registered with same email");
        }
        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }
        userService.save(userDto);
        return "redirect:/register?success";
    }

    // handler method to handle list of users
    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    // handler method to handle login details
    @GetMapping("/login")
    public String login(){
        return "login";
    }
}
