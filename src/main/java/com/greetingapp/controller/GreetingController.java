package com.greetingapp.controller;

import com.greetingapp.entity.Greeting;
import com.greetingapp.entity.User;
import com.greetingapp.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;
    /**
     * @Func :Returning JSON Object & Ability To Save App In Repository
     * @Param:Adding first name ,last name
     * {
     *     name=suraj in "params"-POSTMAN
     *     lastname=chaudhary
     * }
     * @URL: http://localhost:8080/home  -Postman-GET
     * @return: hello
     */
    @GetMapping("/home")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        User user = new User();
        user.setFirstName(name);
        return greetingService.addGreeting(user);
    }

    @GetMapping("/path/{id}")
    public Greeting getElementById(@PathVariable Long id){
        return greetingService.getGreetingById(id);
    }
    @GetMapping("/all")
    public List<Greeting> getAll(){
        return greetingService.getAll();
    }
    @PutMapping("/edit/{id}")
    public Greeting editGreetingById(@PathVariable long id, @RequestParam String name){
        return greetingService.editGreetingById(id, name);
    }
    @DeleteMapping("/delete/{id}")
    public List<Greeting> deleteGreetingById(@PathVariable Long id){
        return greetingService.deleteGreetingById(id);
    }
}
