package com.example.controller;

import com.example.service.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = {"/hello"})
public class HelloWorldController {

    /**
     * User service.
     */
    private final UserService userService;


    public HelloWorldController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/{firstName}/{lastName}"}, method = {RequestMethod.GET, RequestMethod.POST})
//    @GetMapping(value = {"/"})
//    @PostMapping(value = {"/"})
//    @DeleteMapping(value = {"/"})
    public String helloWorld(@PathVariable(value = "firstName", required = true) String firstName,
                             @PathVariable("lastName") String lastName,
                             @RequestParam(value = "id", required = false, defaultValue = "0") Integer id) {
        return "Hello world! Welcome " + firstName + " " + lastName + "." + "Id : " + id;
    }
    

}
