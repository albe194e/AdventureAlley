package com.example.adventurealley.Controller;

import com.example.adventurealley.Models.Customer;
import com.example.adventurealley.Models.Products.Product;
import com.example.adventurealley.Models.Products.Type;
import com.example.adventurealley.Models.Reservation;
import com.example.adventurealley.Models.User;
import com.example.adventurealley.Models.UserType;
import com.example.adventurealley.Service.CustomerService;
import com.example.adventurealley.Service.ProductService;
import com.example.adventurealley.Service.ReservationService;
import com.example.adventurealley.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestRestController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ProductService productService;
    @Autowired
    ReservationService reservationService;

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public ArrayList<Object> initData() {

        Customer customer = new Customer();
        Reservation reservation = new Reservation();
        Product product = new Product();

        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("1234");
        admin.setUserType(UserType.ADMIN);

        User employee = new User();
        employee.setUsername("employee");
        employee.setPassword("1234");
        employee.setUserType(UserType.EMPLOYEE);

        customer.setFirstName("Albert");
        customer.setLastName("Einstein");
        customer.setPhone("12345678");
        customer.setEmail("gmail@");
        customer.setAddress("Albertsvej 1");
        customer.setUsername("albert");
        customer.setPassword("1234");

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

        customerService.customerRepo.save(customer);
        productService.productRepo.save(product);
        reservationService.reservationRepo.save(reservation);
        userService.userRepo.save(admin);
        userService.userRepo.save(employee);

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(customer);
        objects.add(product);
        objects.add(reservation);
        return objects;

    }

    @GetMapping("/users")
    public List<User> users() {
        return userService.userRepo.findAll();
    }

    @GetMapping("/customers")
    public List<Customer> customers() {
        return customerService.customerRepo.findAll();
    }

}
