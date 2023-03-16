package com.example.adventurealley.Controller;

import com.example.adventurealley.Models.User;
import com.example.adventurealley.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class AdminRestController {


    @Autowired
    UserService userService;

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User updatedUser) {

        userService.updateUser(id, updatedUser);

    }
    @PostMapping("/createUser")
    public void createUser(@RequestBody User user) {

        userService.createUser(user);

    }
    @GetMapping("/users")
    public List<User> users() {
        return userService.userRepo.findAll();
    }
}
