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

    public void deleteUser(int id) {
        userRepo.deleteById(id);
    }

    public void updateUser(int id, User newUser) {

        User user = userRepo.findById(id).get();

        user.setUsername(newUser.getUsername());
        user.setUserType(newUser.getUserType());

        userRepo.save(user);

    }

    public void createUser(User user) {

        String username = user.getUsername();

        if (!checkIfUserExists(username)) {
            userRepo.save(user);
        }

    }

    public boolean checkIfUserExists(String username) {
        User user = userRepo.findByUsername(username);
        return user != null;
    }
}
