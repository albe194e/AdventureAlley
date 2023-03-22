package com.example.adventurealley.Controller;

import com.example.adventurealley.Models.User;
import com.example.adventurealley.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserRest {

    @Autowired
    UserService userService;

    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }




}
