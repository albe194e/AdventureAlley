package com.example.adventurealley.Service;

import com.example.adventurealley.Models.Products.Equipment;
import com.example.adventurealley.Repositories.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {

  @Autowired
  public EquipmentRepo equipmentRepo;

  public Equipment updateEquipment(int id, Equipment newE) {
    Equipment equipment = equipmentRepo.findById(id).get();
    equipment.setName(newE.getName());
    equipment.setStock(newE.getStock());
    return equipment;
  }


  public void saveEquipment(Equipment equipment) {
    equipmentRepo.save(equipment);
  }
}
