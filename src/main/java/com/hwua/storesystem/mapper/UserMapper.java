package com.hwua.storesystem.mapper;

import com.hwua.storesystem.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    List<User> queryAll();

    User queryById(Integer userId);

    Integer doUpdatePassword(User user);

    Integer doInsert(User user);

    Integer doUpdateStart(Integer userId);

    Integer doUpdateStop(Integer userId);

    Integer doDelete(Integer userId);

    Integer doUpdate(User user);

    List<User> queryUserDel();
}
