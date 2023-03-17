package com.example.adventurealley.Repositories;

import com.example.adventurealley.Models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSlotRepo extends JpaRepository<TimeSlot,Integer> {


}
