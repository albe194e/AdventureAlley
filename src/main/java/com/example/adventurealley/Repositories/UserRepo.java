package com.example.adventurealley.Repositories;

import com.example.adventurealley.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
