package com.example.adventurealley.Models;

import com.example.adventurealley.Models.Products.Activity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "timeslot")
public class TimeSlot {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int infoId;

    @OneToMany(mappedBy = "timeSlot")
    @JsonBackReference
    private Set<Activity> activities = new HashSet<>();

    private String date, startTime, endTime;

    public Set<Activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
