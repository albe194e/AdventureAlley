package com.example.adventurealley.Models;

import com.example.adventurealley.Models.Products.Activity;

import jakarta.persistence.*;


@Entity
@Table(name = "timeslot")
public class TimeSlot {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int infoId;

    @ManyToOne
    @JoinColumn(name = "activityId", referencedColumnName = "activityId")
    private Activity activity;

    private String date, startTime, endTime;

    public Activity getActivity() {
        return activity;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
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
