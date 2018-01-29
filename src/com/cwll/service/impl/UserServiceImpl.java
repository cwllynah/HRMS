package com.cwll.service.impl;

import com.cwll.dao.UserMapper;
import com.cwll.model.User;
import com.cwll.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cwll on 2018/1/26.
 */
@Transactional
@Component(value = "userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public boolean register(User user) {
        int add = userMapper.add(user);
        if (add>0)
            return true;
        return false;
    }

    @Override
    public User login(User user) {
        return userMapper.findUser(user);
    }

    @Override
    public boolean updateById(User user) {
        System.out.println("service更新user："+user);
        userMapper.updateById(user);
        return true;
    }

    //    游客身份变更员工
    @Override
    public boolean identityEmployee(User user) {
        user.setIdentity(1);
        return updateById(user);
    }

    @Override
    public boolean nameExit(String name) {
        List<User> users= userMapper.nameExit(name);
        if (users!=null&&users.size()>0)
            return false;
        return true;
    }
}
