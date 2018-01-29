package com.cwll.dao;

import com.cwll.model.User;

import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
public interface UserMapper {
    int add(User user);
    User findUser(User user);
    User findUserById(int userId);

    void updateById(User user);

    List<User> nameExit(String name);
}
