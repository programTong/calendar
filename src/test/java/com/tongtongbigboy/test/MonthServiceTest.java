package com.tongtongbigboy.test;

import cn.hutool.core.date.DateTime;
import com.tongtongbigboy.service.month.impl.MonthService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = App.class)
@RunWith(SpringRunner.class)
public class MonthServiceTest {

    @Autowired
    private MonthService monthService;

    @Test
    public void testMonthView() {
        monthService.monthView(DateTime.now());
    }
}
