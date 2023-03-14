package com.example.adventurealley.Repositories;

import com.example.adventurealley.Models.Products.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
