package com.example.wjj3fragemt;

import java.io.Serializable;

/**
 * Created by 16221 on 2018/2/8.
 */

public class DataTime implements Serializable{
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMin(int min) {
        this.min = min;
    }
    public void setRest(String rest) {
        this.rest = rest;
    }
    public String getRest() {
        return rest;
    }


    private int year;
    private int month;
    private int day;
    private int hour;
    private int min;
    private String rest;


}
