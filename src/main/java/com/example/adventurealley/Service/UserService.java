package com.example.adventurealley.Service;

import com.example.adventurealley.Models.User;
import com.example.adventurealley.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepo userRepo;


    public Optional<User> findUser(User user){

        String username = user.getUsername();
        String password = user.getPassword();

        return userRepo.findByUsernameAndPassword(username, password);

    }

    public User findUserByUsername(String username) {

        return userRepo.findByUsername(username);
    }
}
