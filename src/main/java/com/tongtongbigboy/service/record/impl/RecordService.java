package com.tongtongbigboy.service.record.impl;

import com.tongtongbigboy.mapper.RecordMapper;
import com.tongtongbigboy.model.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordMapper recordMapper;

    public boolean addRecord(Record record) {
        int count = recordMapper.addRecord(record);
        return true;
    }

    public List<Record> records(int uid, int year, int month, int day){
        List<Record> list = recordMapper.findByDate(uid,year, month, day);
        return list;
    }

    public void deleteRecord(Record record) {
        recordMapper.delete(record);
    }
}
