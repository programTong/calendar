package com.tongtongbigboy.service.user.impl;


import com.alibaba.fastjson.JSONObject;
import com.tongtongbigboy.Application;
import com.tongtongbigboy.mapper.UserMapper;
import com.tongtongbigboy.model.User;
import com.tongtongbigboy.service.user.UserService;
import com.tongtongbigboy.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 示例Service实现
 * @author tongtongbigboy
 * @date 2021/05/29 19:31
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Override
    public Integer create(User user) {
        String password = user.getPassword();
        String newPassword = encoder.encode(password);
        user.setPassword(newPassword);
        int count = userMapper.createByUser(user);
        return count;
    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public void deleteByIdInBatch(List<Integer> ids) {

    }

    @Override
    public void updateById(User user) {

    }

    @Override
    public void updateByIdInBatch(List<User> users) {

    }

    @Override
    public User findById(Integer id) {
        System.out.println("findById-"+id);
        return null;
    }

    @Override
    public User findOne(User user) {
        return null;
    }

    @Override
    public List<User> findList(User user) {
        return null;
    }


    @Override
    public long count(User user) {
        return 0;
    }

    @Override
    public User findByUser(User user) {
        User user0 = userMapper.findByUserName(user.getUsername());
        Application.log.info("{}用户输入的密码: {}", LogUtils.current(),user.getPassword());
        if (user0 != null){
            Application.log.info("{}用户在数据库中的密码: {}",LogUtils.current(),user0.getPassword());
        }
        if (user0 !=null && encoder.matches(user.getPassword(),user0.getPassword())){
            return user0;
        }else{
            return null;
        }
    }

    @Override
    public JSONObject findByUserName(String username) {
        User user = userMapper.findByUserName(username);
        JSONObject json = new JSONObject();
        if (user == null) {
            json.put("user_existed", false);
        }else {
            json.put("user_existed", true);
        }
        return json;
    }
}
