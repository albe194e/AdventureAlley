package com.example.adventurealley.Service;

import com.example.adventurealley.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;


}
