package com.example.adventurealley.Service;

import com.example.adventurealley.Repositories.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {

  @Autowired
  public EquipmentRepo equipmentRepo;
}
