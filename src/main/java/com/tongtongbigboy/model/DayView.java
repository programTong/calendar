package com.tongtongbigboy.model;

import java.util.List;

public class DayView {

    private int year;
    private int month;
    private int day;
    private String chineseMonth;
    private String chineseDay;
    private int recordCount;
    private List<Record> records;

    public String getChineseMonth() {
        return chineseMonth;
    }

    public void setChineseMonth(String chineseMonth) {
        this.chineseMonth = chineseMonth;
    }

    public String getChineseDay() {
        return chineseDay;
    }

    public void setChineseDay(String chineseDay) {
        this.chineseDay = chineseDay;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }
}
