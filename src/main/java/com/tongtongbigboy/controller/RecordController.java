package com.tongtongbigboy.controller;

import com.tongtongbigboy.Application;
import com.tongtongbigboy.common.Result;
import com.tongtongbigboy.common.StatusCode;
import com.tongtongbigboy.model.Record;
import com.tongtongbigboy.service.record.impl.RecordService;
import com.tongtongbigboy.util.LogUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/record")
@CrossOrigin
public class RecordController {

    @Autowired
    private RecordService recordService;

    /**
     *
     * @param record
     * @return
     */
    @PostMapping("/add")
    public Result add(@RequestBody Record record, HttpServletRequest request){
        Claims user_claims = (Claims)request.getAttribute("user_claims");
        if (user_claims==null){
            return new Result(true, StatusCode.OK,"未登录");
        }
        Application.log.info("{}{}", LogUtils.current(),record);
        boolean flag = recordService.addRecord(record);
        if (flag){
           return new Result(true,StatusCode.OK, "添加日程成功");
        }else {
            return new Result(false,StatusCode.ERROR, "添加日程失败");
        }
    }

    /**
     *
     * @param record
     * @return
     */
    @DeleteMapping()
    public Result delete(@RequestBody Record record, HttpServletRequest request){
        Claims user_claims = (Claims)request.getAttribute("user_claims");
        if (user_claims==null){
            return new Result(true, StatusCode.OK,"未登录");
        }
        recordService.deleteRecord(record);
        return new Result(true,StatusCode.OK, "删除日程成功");
    }
}
