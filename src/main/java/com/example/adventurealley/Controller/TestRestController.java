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

        //Instantiate customer
        Customer customer = new Customer(
                "William",
                "Hansen",
                "@gmail.com",
                "12345678",
                "Skovvejen 24",
                "test",
                "1234");

        //Instantiate Users
        User admin = new User("admin", "1234", UserType.ADMIN);
        User employee = new User("employee", "1234", UserType.EMPLOYEE);

        userService.userRepo.save(admin);
        userService.userRepo.save(employee);

        //Instantiate activities
        Activity gokart = new Activity("GoKart","12",200.0);
        Activity minigolf = new Activity("MiniGolf","4",200.0);
        Activity paintball = new Activity("Paintball","12",200.0);
        Activity sumoWrestling = new Activity("SumoWrestling","5",200.0);


        //Instantiate equipment
        Equipment gokartEquipment = new Equipment("GoKart", 5);
        Equipment minigolfEquipment = new Equipment("MiniGolf", 5);
        Equipment paintballEquipment = new Equipment("Paintball", 5);
        Equipment sumoWrestlingEquipment = new Equipment("SumoWrestling", 5);


        //Save activities and equipment
        equipmentService.saveEquipment(gokartEquipment);
        equipmentService.saveEquipment(minigolfEquipment);
        equipmentService.saveEquipment(paintballEquipment);
        equipmentService.saveEquipment(sumoWrestlingEquipment);

        gokart.setEquipment(gokartEquipment);
        minigolf.setEquipment(minigolfEquipment);
        paintball.setEquipment(paintballEquipment);
        sumoWrestling.setEquipment(sumoWrestlingEquipment);

        activityService.saveActivity(gokart);
        activityService.saveActivity(minigolf);
        activityService.saveActivity(paintball);
        activityService.saveActivity(sumoWrestling);


        customerService.customerRepo.save(customer);


        ArrayList<Object> objects = new ArrayList<>();

        objects.add(customer);
        objects.add(activityService.activityRepo.findAll());
        objects.add(equipmentService.equipmentRepo.findAll());

        return objects;

    }




    /*
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


     */

}

