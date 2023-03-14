package com.example.adventurealley.Service;

import com.example.adventurealley.Repositories.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    public ProductRepo productRepo;

}
