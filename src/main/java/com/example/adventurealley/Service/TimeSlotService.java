package com.example.adventurealley.Service;

import com.example.adventurealley.Repositories.TimeSlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeSlotService {


    @Autowired
    public TimeSlotRepo timeSlotRepo;


}
