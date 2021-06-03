package com.tongtongbigboy.controller;

import com.tongtongbigboy.Application;
import com.tongtongbigboy.common.Result;
import com.tongtongbigboy.common.StatusCode;
import com.tongtongbigboy.model.User;
import com.tongtongbigboy.service.user.UserService;
import com.tongtongbigboy.util.JwtUtil;
import com.tongtongbigboy.util.LogUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author tongtongbigboy
 * @date 2021/05/29 19:31
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController  {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 创建
     * @author tongtongbigboy
     * @date 2021/05/29 19:31
     */
    @PostMapping("/register")
    public Result register(@RequestBody User req) {
        return new Result(true, StatusCode.OK,"创建用户成功",userService.create(req));
    }

    /**
     * 通过id查询
     * @author tongtongbigboy
     * @date 2021/05/29 19:31
     */
    @GetMapping("/{id}")
    public Result finById(@PathVariable Integer id) {
        return new Result(true, StatusCode.OK,"查询用户成功",userService.findById(id));
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        User user0 = userService.findByUser(user);
        if (user0 == null) {
            return new Result(false, StatusCode.USER_PASSWORD_UNCORRECTED,"用户名或密码错误");
        }else{
            String token = jwtUtil.createJWT(String.valueOf(user.getId()), user.getUsername(), "user");
            Map<String,Object> map = new HashMap<>();
            map.put("token",token);
            map.put("role","user");
            map.put("uid",user0.getId());
            return new Result(true, StatusCode.OK,"登录成功",map);
        }
    }

    @GetMapping("/findByUserName/{username}")
    public Result findByUserName(@PathVariable String username) {
        Application.log.info("{}username: {}", LogUtils.higher(),username);
        return new Result(true, StatusCode.OK,"查询用户成功",userService.findByUserName(username));
    }

    /**
     * 根据ID修改
     * @author tongtongbigboy
     * @date 2021/05/29 19:31
     */
    @PostMapping("/updateById")
    public Result updateById(HttpServletRequest request) {
        Claims user_claims = (Claims)request.getAttribute("user_claims");
        if (user_claims==null){
            return new Result(true, StatusCode.OK,"未登录");
        }
        userService.updateById(new User());
        return new Result(true, StatusCode.OK,"更新用户成功");
    }

    /**
     * 根据ID删除
     * @author tongtongbigboy
     * @date 2021/05/29 19:31
     */
    @GetMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        userService.deleteById(id);
        return new Result(true, StatusCode.OK,"删除用户成功");
    }



}
