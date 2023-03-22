package com.example.adventurealley.Controller;

import com.example.adventurealley.Models.Customer;
import com.example.adventurealley.Models.Reservation;
import com.example.adventurealley.Models.TimeSlot;
import com.example.adventurealley.Service.CustomerService;
import com.example.adventurealley.Service.ReservationService;
import com.example.adventurealley.Service.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CustomerREST {


    @Autowired
    CustomerService customerService;
    @Autowired
    ReservationService reservationService;
    @Autowired
    TimeSlotService timeSlotService;

    //GET
    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable int id) {
        return customerService.customerRepo.findById(id).orElse(null);
    }

    @GetMapping("/customers")
    public List<Customer> customers() {
        return customerService.customerRepo.findAll();
    }

    @GetMapping("/getReservationByCustomer/{id}")
    public List<Reservation> getReservationsByCustomer(@PathVariable int id){

        System.out.println(id);
        return reservationService.reservationRepo.findAllByCustomerCustomerId(id);
    }


    //POST
    @PostMapping("/createCustomer")
    public void CreateCustomer(@RequestBody Customer customer) {
        customerService.customerRepo.save(customer);
    }

    @PostMapping("/createReservation")
    public void createReservation(@RequestBody Reservation reservation){

        System.out.println(reservation.toString());

        TimeSlot timeSlot = timeSlotService.getTimeSlot(reservation.getTimeSlot().getTimeSlotId()).orElse(null);
        timeSlot.setBooked(true);

        timeSlotService.timeSlotRepo.save(timeSlot);

        reservationService.createReservation(reservation);

    }


    //PUT
    @PutMapping("/updateCustomer/{id}")
    public void updateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customerService.updateCustomer(id, customer);
    }

    //DELETE
    @DeleteMapping("/deleteCustomer/{id}")
    public void deleteCustomer(@PathVariable int id) {
        customerService.deleteCustomer(id);
    }

    @DeleteMapping("/deleteReservation/{id}")
    public void deleteReservation(@PathVariable int id) {

        Reservation reservation = reservationService.reservationRepo.findById(id).orElse(null);

        timeSlotService.changeTimeSlotToAvailable(reservation.getTimeSlot().getTimeSlotId());
        reservationService.deleteReservation(id);
    }

}


