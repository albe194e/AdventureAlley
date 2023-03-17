package com.example.adventurealley.Repositories;

import com.example.adventurealley.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ReservationRepo extends JpaRepository<Reservation,Integer> {

  void deleteAllByInfo_InfoId(int id);
}
