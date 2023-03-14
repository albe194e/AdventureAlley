package com.example.adventurealley.Repositories;

import com.example.adventurealley.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
