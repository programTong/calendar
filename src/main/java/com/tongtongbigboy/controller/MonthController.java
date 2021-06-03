package com.tongtongbigboy.controller;

import cn.hutool.core.date.DateTime;
import com.tongtongbigboy.common.Result;
import com.tongtongbigboy.common.StatusCode;
import com.tongtongbigboy.model.MonthView;
import com.tongtongbigboy.service.month.impl.MonthService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RestController
@RequestMapping("/month")
@CrossOrigin
public class MonthController {
    @Autowired
    private MonthService monthService;

    /**
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/monthView", method = RequestMethod.GET)
    public Result monthView(HttpServletRequest request) {
        Claims user_claims = (Claims)request.getAttribute("user_claims");
        if (user_claims==null){
            return new Result(false, StatusCode.ERROR,"未登录");
        }
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");
        String uid = request.getParameter("uid");
        Date date = DateTime.of(year+"-"+month+"-"+day, "yyyy-MM-dd");
        MonthView monthView = monthService.monthView(Integer.parseInt(uid),date);
        return new Result(true, StatusCode.OK,"获取数据成功",monthView);
    }



}
