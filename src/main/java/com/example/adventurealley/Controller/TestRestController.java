package com.example.adventurealley.Controller;

import com.example.adventurealley.Models.*;
import com.example.adventurealley.Models.Products.Equipment;
import com.example.adventurealley.Models.Products.Activity;
import com.example.adventurealley.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
public class TestRestController {

    @Autowired
    CustomerService customerService;
    @Autowired
    ActivityService activityService;
    @Autowired
    ReservationService reservationService;

    @Autowired
    UserService userService;

    @Autowired
    EquipmentService equipmentService;

    @Autowired
    TimeSlotService timeSlotService;

    @GetMapping("/test")
    public ArrayList<Object> initData() {

        Customer customer = new Customer();
        Reservation reservation = new Reservation();
        Activity activity = new Activity();
        Equipment equipment = new Equipment();
        TimeSlot timeSlot = new TimeSlot();

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



        timeSlot.setStartTime("12:00");
        timeSlot.setEndTime("13:00");
        timeSlot.setDate("2021-05-05");




        equipment.setName("Bungee Equipment");
        equipment.setStock(4);

        activity.setName("Bungee Jump");
        activity.setAgeLimit("18+");
        activity.setPrice(500.5);
        activity.setEquipment(equipment);

        timeSlot.getActivities().add(activity);

        timeSlotService.timeSlotRepo.save(timeSlot);

        reservation.setInfo(timeSlot);

        activity.setTimeSlot(timeSlot);

        reservation.setCustomer(customer);

        equipmentService.equipmentRepo.save(equipment);
        customerService.customerRepo.save(customer);
        activityService.activityRepo.save(activity);
        userService.userRepo.save(admin);
        userService.userRepo.save(employee);
        reservationService.reservationRepo.save(reservation);



        ArrayList<Object> objects = new ArrayList<>();
        objects.add(customer);
        objects.add(activity);
        objects.add(reservation);
        objects.add(equipment);
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

    @GetMapping("/products")
    public List<Activity> products() {
        return activityService.activityRepo.findAll();
    }

    @PostMapping("/validateCustomerLogin")
    public boolean login(@RequestBody Customer customer) {

        Optional<Customer> customerOptional = customerService.findCustomer(customer);

        return customerOptional.isPresent();
    }

    @PostMapping("/validateUserLogin")
    public User login(@RequestBody User user) {

        String username = user.getUsername();
        String password = user.getPassword();

        Optional<User> userOptional = userService.findUser(username, password);

        System.out.println(userOptional.isPresent());

        return userOptional.orElse(null);
    }
    @GetMapping("/user/{username}")
    public User getUser(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }



}
