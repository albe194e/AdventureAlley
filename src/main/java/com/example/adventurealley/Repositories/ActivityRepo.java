package com.example.adventurealley.Repositories;

import com.example.adventurealley.Models.Products.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepo extends JpaRepository<Activity,Integer> {
}
