package com.example.adventurealley.Service;

import com.example.adventurealley.Models.TimeSlot;
import com.example.adventurealley.Repositories.TimeSlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TimeSlotService {


  @Autowired
  public TimeSlotRepo timeSlotRepo;

  public ArrayList<Integer> returnTimeSlotByActivity(int id) {
    List<TimeSlot> TSRList;
    TSRList = timeSlotRepo.findAll();
    ArrayList<Integer> TSRId = new ArrayList<>();

    for (int i = 0; i < TSRList.size(); i++) {
      if (TSRList.get(i).getActivity().getActivityId() == id) {
        TSRId.add(TSRList.get(i).getInfoId());
      }
    }
    return TSRId;
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
}
