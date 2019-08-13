package com.hwua.storesystem.service.impl;

import com.hwua.storesystem.entity.User;
import com.hwua.storesystem.mapper.UserMapper;
import com.hwua.storesystem.service.UserService;
import com.hwua.storesystem.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.queryAll();
    }

    @Override
    public User getById(Integer userId) {
        return userMapper.queryById(userId);
    }

    @Override
    public Boolean changePassword(Integer userId, String password) {
        User user = userMapper.queryById(userId);
        String userName = user.getUsername();
        String md5 = MD5Util.getMd5(userName.concat(password));
        user.setPassword(md5);
        return userMapper.doUpdatePassword(user) == 1;
    }

    @Override
    public Boolean insertOrUpdate(User user) {
        Integer result;
        if (user.getUserId() != null){
            result = userMapper.doUpdate(user);
        }else {
            result = userMapper.doInsert(user);
        }
        return result == 1;
    }

    @Override
    public Boolean alterStatus(String operate, Integer userId) {
        Integer result;
        if ("启用".equals(operate)) {
            result = userMapper.doUpdateStart(userId);
        }else {
            result = userMapper.doUpdateStop(userId);
        }
        return result == 1;
    }

    @Override
    public Boolean delete(Integer userId) {
        return userMapper.doDelete(userId) == 1;
    }

    @Override
    public List<User> getUserDel() {
        return userMapper.queryUserDel();
    }
}
