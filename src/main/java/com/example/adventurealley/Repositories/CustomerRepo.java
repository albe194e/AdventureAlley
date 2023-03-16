package com.example.adventurealley.Repositories;

import com.example.adventurealley.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Optional<Customer> findByUsernameAndPassword(String username, String password);

}
