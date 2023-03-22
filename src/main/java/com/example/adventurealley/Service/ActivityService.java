package com.example.adventurealley.Service;

import com.example.adventurealley.Models.Products.Activity;
import com.example.adventurealley.Models.Products.Equipment;
import com.example.adventurealley.Models.Products.Activity;
import com.example.adventurealley.Repositories.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ActivityService {

    @Autowired
    public ActivityRepo activityRepo;

    public void deleteActivity(int id) {
        System.out.println("JEg viriker");
        activityRepo.deleteById(id);
    }

    public void updateActivity(int id, Activity newA) {
        Activity activity = activityRepo.findById(id).get();

        activity.setName(newA.getName());
        activity.setAgeLimit(newA.getAgeLimit());
        activity.setPrice(newA.getPrice());

    }

    public Optional<Activity> getActivityById(int id) {
        return activityRepo.findById(id);
    }


    public boolean checkIfActivityExists(String activityName) {
        Activity activity = activityRepo.findByName(activityName);

        return activity != null;

    }

}
