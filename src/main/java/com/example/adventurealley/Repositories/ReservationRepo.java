package com.example.adventurealley.Repositories;

import com.example.adventurealley.Models.Reservation;
import com.example.adventurealley.Models.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ReservationRepo extends JpaRepository<Reservation,Integer> {

  void deleteAllByTimeSlot(TimeSlot timeSlot);
}
