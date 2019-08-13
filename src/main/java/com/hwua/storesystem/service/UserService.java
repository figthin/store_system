package com.hwua.storesystem.service;

import com.hwua.storesystem.entity.User;

import java.util.List;

public interface UserService {

    List<User> list();

    User getById(Integer userId);

    Boolean changePassword(Integer userId, String password);

    Boolean insertOrUpdate(User user);

    Boolean alterStatus(String operate, Integer userId);

    Boolean delete(Integer userId);

    List<User> getUserDel();
}
