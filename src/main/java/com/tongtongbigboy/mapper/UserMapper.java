package com.tongtongbigboy.mapper;


import com.tongtongbigboy.model.User;

public interface UserMapper {

    User findByUser(User user);

    User findByUserName(String username);

    int createByUser(User user);
}
