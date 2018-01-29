package com.cwll.service;

import com.cwll.model.User;


/**
 * Created by cwll on 2018/1/26.
 */
public interface UserService {
    boolean register(User user);
    User login(User user);

    boolean updateById(User user);

    boolean identityEmployee(User user);

    boolean nameExit(String name);
}
