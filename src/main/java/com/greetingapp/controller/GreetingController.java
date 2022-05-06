package com.greetingapp.controller;

import com.greetingapp.entity.Greeting;
import com.greetingapp.entity.User;
import com.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/home")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }
}
