package com.example.adventurealley.Service;

import com.example.adventurealley.Repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    public ReservationRepo reservationRepo;

}
