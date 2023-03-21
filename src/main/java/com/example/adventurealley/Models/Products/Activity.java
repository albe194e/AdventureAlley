package com.example.adventurealley.Models.Products;
import jakarta.persistence.*;


@Entity
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int activityId;

    private String name, ageLimit;

    private double price;

    @OneToOne
    @JoinColumn(name = "equipmentID", referencedColumnName = "equipmentID")
    private Equipment equipment;


    public Activity() {}

    public Activity(String name, String ageLimit, double price, Equipment equipment) {
        this.name = name;
        this.ageLimit = ageLimit;
        this.price = price;
        this.equipment = equipment;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(String ageLimit) {
        this.ageLimit = ageLimit;
    }





    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
