package com.example.adventurealley.Controller;

import com.example.adventurealley.Models.Products.Activity;
import com.example.adventurealley.Models.TimeSlot;
import com.example.adventurealley.Service.ActivityService;
import com.example.adventurealley.Service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TimeSlotGenerationREST {


    @Autowired
    TimeSlotService timeSlotService;

    @Autowired
    ActivityService activityService;

    @GetMapping("/generateTimeSlots")
    public List<TimeSlot> generateTimeSlots() {

        List<Activity> activities = activityService.activityRepo.findAll();


        return timeSlotService.generateTimeSlots(activities);
    }

    @GetMapping("/timeslotsByActivity/{id}")
    public List<TimeSlot> timeslotsByActivity(@PathVariable int id) {
        return timeSlotService.returnTimeSlotByActivity(id);
    }
    @GetMapping("/timeSlot/{id}")
    public TimeSlot getTimeSlot(@PathVariable int id) {


        return timeSlotService.getTimeSlot(id).orElse(null);
    }
}
