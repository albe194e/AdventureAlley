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

    public void updateCustomer(int id, Customer newCustomer) {
        Customer customer = customerRepo.findById(id).get();

        customer.setPassword(newCustomer.getPassword());
        customer.setAddress(newCustomer.getAddress());
        customer.setEmail(newCustomer.getEmail());
        customer.setPhone(newCustomer.getPhone());

        customerRepo.save(customer);
    }

    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }
}
