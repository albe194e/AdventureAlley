package com.example.adventurealley.Models.Products;

import jakarta.persistence.*;

@Entity
public class Equipment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int equipmentID;

  String name;
  int Stock;



  public Equipment() {}


    public Equipment(String name, int stock) {
        this.name = name;
        Stock = stock;
    }

  public int getEquipmentID() {
    return equipmentID;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getStock() {
    return Stock;
  }

  public void setStock(int stock) {
    Stock = stock;
  }
}
