package com.example.adventurealley.Service;

import com.example.adventurealley.Models.Reservation;
import com.example.adventurealley.Models.TimeSlot;
import com.example.adventurealley.Repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    public ReservationRepo reservationRepo;

    public void deleteReservationByTimeSlot(TimeSlot timeSlot) {
        /*
        List<Reservation> RList;
        RList = reservationRepo.findAll();

        for (int i = 0; i < RList.size(); i++) {
            if (RList.get(i).getInfo().getInfoId() == id) {
                reservationRepo.delete(RList.get(i));
            }
        }

         */

        reservationRepo.deleteAllByTimeSlot(timeSlot);
    }

    public void createReservation(Reservation reservation) {

        Reservation newReservation = new Reservation();



        newReservation.setCustomer(reservation.getCustomer());
        newReservation.setTimeSlot(reservation.getTimeSlot());

        reservationRepo.save(newReservation);

    }

    public void deleteReservation(int id) {

        reservationRepo.deleteById(id);
    }
}
