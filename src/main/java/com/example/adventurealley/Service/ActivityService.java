package com.example.adventurealley.Service;

import com.example.adventurealley.Repositories.ActivityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    public ActivityRepo activityRepo;

    public void deleteActivity(int id) {
        System.out.println("JEg viriker");
        activityRepo.deleteById(id);
    }

}
