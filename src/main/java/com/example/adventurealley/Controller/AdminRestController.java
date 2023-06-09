package com.example.adventurealley.Controller;

import com.example.adventurealley.Models.Products.Activity;
import com.example.adventurealley.Models.Products.Equipment;
import com.example.adventurealley.Models.TimeSlot;
import com.example.adventurealley.Models.User;
import com.example.adventurealley.Service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class AdminRestController {


    @Autowired
    EquipmentService equipmentService;

    @Autowired
    ReservationService reservationService;
    @Autowired
    TimeSlotService timeSlotService;

    @Autowired
    UserService userService;

    @Autowired
    ActivityService activityService;




    //GET
    @GetMapping("/users")
    public List<User> users() {
        return userService.userRepo.findAll();
    }

    @GetMapping("/equipment")
    public List<Equipment> equipment() {
        return equipmentService.equipmentRepo.findAll();
    }


    @GetMapping("/products")
    public List<Activity> products() {
        return activityService.activityRepo.findAll();
    }


    //POST / CREATE
    @PostMapping("/createUser")
    public void createUser(@RequestBody User user) {

        System.out.println(user.getUsername());

        userService.createUser(user);

    }

    @PostMapping("/createActivity")
    public void createActivity(@RequestBody Activity activity) {

        activityService.activityRepo.save(activity);
    }


    @PostMapping("/createEquipment")
    public void createEquipment(@RequestBody Equipment equipment) {
        equipmentService.equipmentRepo.save(equipment);
    }


    //PUT
    @PutMapping("/updateUser/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User updatedUser) {

        userService.updateUser(id, updatedUser);

    }

    //DELETE
    @DeleteMapping("/deleteActivity/{id}")
    @Transactional
    public void deleteActivity(@PathVariable int id) {
        ArrayList<TimeSlot> timeSlotId;
        timeSlotId = timeSlotService.returnTimeSlotByActivity(id);

        for (TimeSlot timeSlot : timeSlotId) {

            reservationService.deleteReservationByTimeSlot(timeSlot);
        }

        timeSlotService.deleteTimeSlotByActivity(id);
        activityService.deleteActivity(id);
    }

    @PutMapping("/updateEquipment/{id}")
    public void updateEquipment(@PathVariable int id, @RequestBody Equipment updatedEquipment) {
       equipmentService.updateEquipment(id, updatedEquipment);
    }

    @PutMapping("/updateActivity/{id}")
    public void updateActivity(@PathVariable int id, @RequestBody Activity updatedActivity) {
        activityService.updateActivity(id, updatedActivity);
    }

    @GetMapping("/Activity/{id}")
    public Activity getActivity(@PathVariable int id) {
        return activityService.getActivityById(id).orElse(null);
    }
    @DeleteMapping("/deleteUser/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}