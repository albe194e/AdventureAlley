package com.example.adventurealley.Repositories;

import com.example.adventurealley.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepo extends JpaRepository<Reservation,Integer> {
}
