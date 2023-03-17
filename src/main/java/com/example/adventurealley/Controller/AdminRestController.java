package com.example.adventurealley.Controller;

import com.example.adventurealley.Models.User;
import com.example.adventurealley.Service.ActivityService;
import com.example.adventurealley.Service.ReservationService;
import com.example.adventurealley.Service.TimeSlotService;
import com.example.adventurealley.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class AdminRestController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    TimeSlotService timeSlotService;

    @Autowired
    UserService userService;

    @Autowired
    ActivityService activityService;

    @DeleteMapping("/deleteActivity/{id}")
    public void deleteActivity(@PathVariable int id) {
        ArrayList<Integer> timeSlotId;
        timeSlotId = timeSlotService.returnTimeSlotByActivity(id);
        for (int i = 0; i < timeSlotId.size(); i++) {
            reservationService.deleteReservationByTimeSlot(timeSlotId.get(i));
        }
        timeSlotService.deleteTimeSlotByActivity(id);
        activityService.deleteActivity(id);
    }

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

        System.out.println(user.getUsername());

        userService.createUser(user);

    }
    @GetMapping("/users")
    public List<User> users() {
        return userService.userRepo.findAll();
    }
}