package com.example.adventurealley.Service;

import com.example.adventurealley.Repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    public CustomerRepo customerRepo;

}
