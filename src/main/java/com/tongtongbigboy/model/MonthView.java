package com.tongtongbigboy.model;

import java.util.List;

public class MonthView {
    private int year;
    private int month;
    private int dayCount;
    private List<DayView> dayViews;
    private String chineseMonth;
    private int todayIndex;
    private int beginOfMonthIndex;

    public int getBeginOfMonthIndex() {
        return beginOfMonthIndex;
    }

    public void setBeginOfMonthIndex(int beginOfMonthIndex) {
        this.beginOfMonthIndex = beginOfMonthIndex;
    }

    public int getTodayIndex() {
        return todayIndex;
    }

    public void setTodayIndex(int todayIndex) {
        this.todayIndex = todayIndex;
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

    public String getChineseMonth() {
        return chineseMonth;
    }

    public void setChineseMonth(String chineseMonth) {
        this.chineseMonth = chineseMonth;
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public List<DayView> getDayViews() {
        return dayViews;
    }

    public void setDayViews(List<DayView> dayViews) {
        this.dayViews = dayViews;
    }
}
