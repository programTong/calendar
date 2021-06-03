package com.tongtongbigboy.mapper;

import com.tongtongbigboy.model.Record;

import java.util.List;


public interface RecordMapper {

    List<Record> findByDate(int uid, int year, int month, int day);

    int addRecord(Record record);

    void delete(Record record);

}
