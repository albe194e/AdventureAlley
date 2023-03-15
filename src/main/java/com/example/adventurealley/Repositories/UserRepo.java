package com.example.adventurealley.Repositories;

import com.example.adventurealley.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> {



    Optional<User> findByUsernameAndPassword(String username, String password);

    User findByUsername(String username);
}
