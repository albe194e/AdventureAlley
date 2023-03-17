package com.example.adventurealley.Models;


import jakarta.persistence.*;

@Entity
public class Reservation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reservationId;
    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "customerId")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "timeSlotId", referencedColumnName = "timeSlotId")
    private TimeSlot timeSlot;



    public TimeSlot getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(TimeSlot info) {
        this.timeSlot = info;
    }

    public Reservation() {}

    public int getReservationId() {
        return reservationId;
    }


    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setReservationID(int reservationId) {
        this.reservationId = reservationId;
    }
}
