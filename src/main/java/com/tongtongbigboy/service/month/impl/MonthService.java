package com.tongtongbigboy.service.month.impl;

import cn.hutool.core.date.ChineseDate;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.tongtongbigboy.model.DayView;
import com.tongtongbigboy.model.MonthView;
import com.tongtongbigboy.model.Record;
import com.tongtongbigboy.service.record.impl.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MonthService {

    @Autowired
    private RecordService recordService;


    public MonthView monthView(int uid, Date date) {
        DateTime beginOfMonth = DateUtil.beginOfMonth(date);
        int indexOfFirstDayOfMonth = beginOfMonth.dayOfWeek()-1;
        int todayIndex = indexOfFirstDayOfMonth+DateUtil.dayOfMonth(date)-1;
        DateTime dateTime = DateUtil.offset(beginOfMonth, DateField.DAY_OF_MONTH, -indexOfFirstDayOfMonth);
        dateTime.setMutable(true);
        List<DayView> dayViews = new ArrayList<>();
        for (int i = 0; i < 42; i++) {
            DayView dayView = new DayView();
            ChineseDate chineseDate = new ChineseDate(dateTime);
            dayView.setDay(dateTime.dayOfMonth());
            dayView.setMonth(dateTime.month()+1);
            dayView.setYear(dateTime.year());
            dayView.setChineseDay(chineseDate.getChineseDay());
            dayView.setChineseMonth(chineseDate.getChineseMonth());
            List<Record> records = recordService.records(uid,dayView.getYear(),dayView.getMonth(),dayView.getDay());
            dayView.setRecordCount(records.size());
            dayView.setRecords(records);
            dayViews.add(dayView);
            dateTime.offset(DateField.DAY_OF_MONTH, 1);
        }

        MonthView monthView = new MonthView();
        monthView.setDayCount(DateUtil.endOfMonth(date).dayOfMonth());
        monthView.setDayViews(dayViews);
        monthView.setTodayIndex(todayIndex);
        monthView.setYear(beginOfMonth.year());
        monthView.setMonth(beginOfMonth.month()+1);
        monthView.setBeginOfMonthIndex(indexOfFirstDayOfMonth);
        return monthView;
    }
}
