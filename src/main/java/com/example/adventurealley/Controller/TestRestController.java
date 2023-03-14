package com.example.adventurealley.Controller;

import com.example.adventurealley.Models.Customer;
import com.example.adventurealley.Models.Products.Product;
import com.example.adventurealley.Models.Products.Type;
import com.example.adventurealley.Models.Reservation;
import com.example.adventurealley.Repositories.CustomerRepo;
import com.example.adventurealley.Repositories.ProductRepo;
import com.example.adventurealley.Repositories.ReservationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class TestRestController {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    ProductRepo productRepo;
    @Autowired
    ReservationRepo reservationRepo;

    @GetMapping("/test")
    public ArrayList<Object> initData() {

        Customer customer = new Customer();
        Reservation reservation = new Reservation();
        Product product = new Product();

        customer.setFirstName("Albert");
        customer.setLastName("Einstein");
        customer.setPhone("12345678");
        customer.setEmail("gmail@");
        customer.setAddress("Albertsvej 1");

        reservation.setStartTime("12:00");
        reservation.setEndTime("13:00");
        reservation.setDate("2021-05-05");

        product.setName("Bungee Jump");
        product.setType(Type.ACTIVITY);
        product.setAgeLimit("18+");

        reservation.setProduct(product);
        reservation.setCustomer(customer);

        ArrayList<Reservation> reservations = new ArrayList<>();
        reservations.add(reservation);
        customer.setReservations(reservations);

        customerRepo.save(customer);
        productRepo.save(product);
        reservationRepo.save(reservation);

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(customer);
        objects.add(product);
        objects.add(reservation);
        return objects;

    }

}
