package com.example.adventurealley.Service;

import com.example.adventurealley.Models.Products.Activity;
import com.example.adventurealley.Models.TimeSlot;
import com.example.adventurealley.Repositories.TimeSlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TimeSlotService {


    @Autowired
    public TimeSlotRepo timeSlotRepo;

    public ArrayList<TimeSlot> returnTimeSlotByActivity(int id) {
        ArrayList<TimeSlot> TSRList;
        TSRList = timeSlotRepo.findAllByActivityActivityId(id);

        return TSRList;
    /*

    ArrayList<Integer> TSRId = new ArrayList<>();

    for (TimeSlot timeSlot : TSRList) {
      TSRId.add(timeSlot.getTimeSlotId());
    }

    for (int i = 0; i < TSRList.size(); i++) {
      if (TSRList.get(i).getActivity().getActivityId() == id) {
        TSRId.add(TSRList.get(i).getInfoId());
      }
    }


    return TSRId;

     */
    }

    public void deleteTimeSlotByActivity(int id) {
        List<TimeSlot> TSRList;
        TSRList = timeSlotRepo.findAll();

        for (int i = 0; i < TSRList.size(); i++) {
            if (TSRList.get(i).getActivity().getActivityId() == id) {
                timeSlotRepo.delete(TSRList.get(i));
            }
        }
    }

    public List<TimeSlot> generateTimeSlots(List<Activity> activities) {

      List<TimeSlot> timeSlots = new ArrayList<>();

        for (Activity activity : activities) {
            for (int i = 10; i < 22; i++) {
            TimeSlot timeSlot = new TimeSlot();
            timeSlot.setBooked(false);
            timeSlot.setActivity(activity);
            timeSlot.setDate(String.valueOf(LocalDate.now()));
            timeSlot.setStartTime(String.valueOf(new Time(i, 0, 0)));
            timeSlot.setEndTime(String.valueOf(new Time(i+1, 0, 0)));
            timeSlots.add(timeSlot);
            }
        }

        return timeSlotRepo.saveAll(timeSlots);
    }

    public Optional<TimeSlot> getTimeSlot(int id) {

        return timeSlotRepo.findById(id);
    }

    public void changeTimeSlotToAvailable(int id) {



        TimeSlot timeSlot = timeSlotRepo.findById(id).get();
        timeSlot.setBooked(false);
        timeSlotRepo.save(timeSlot);
    }
}
