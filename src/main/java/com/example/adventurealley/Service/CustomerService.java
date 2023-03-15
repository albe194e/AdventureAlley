package com.example.adventurealley.Service;

import com.example.adventurealley.Models.Customer;
import com.example.adventurealley.Repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepo customerRepo;

    public Optional<Customer> findCustomer(Customer customer) {

        String username = customer.getUsername();
        String password = customer.getPassword();

        return customerRepo.findByUsernameAndPassword(username, password);

    }
}
