package com.example.adventurealley.Controller;

import com.example.adventurealley.Models.Reservation;
import com.example.adventurealley.Models.TimeSlot;
import com.example.adventurealley.Service.ReservationService;
import com.example.adventurealley.Service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ReservationREST {

    @Autowired
    ReservationService reservationService;

    @Autowired
    TimeSlotService timeSlotService;

    @PostMapping("/createReservation")
    public void createReservation(@RequestBody Reservation reservation){

        System.out.println(reservation.toString());

        TimeSlot timeSlot = timeSlotService.getTimeSlot(reservation.getTimeSlot().getTimeSlotId()).orElse(null);
        timeSlot.setBooked(true);

        timeSlotService.timeSlotRepo.save(timeSlot);

        reservationService.createReservation(reservation);

    }

    @GetMapping("/getReservationByCustomer/{id}")
    public List<Reservation> getReservationsByCustomer(@PathVariable int id){

        System.out.println(id);
        return reservationService.reservationRepo.findAllByCustomerCustomerId(id);
    }


}
