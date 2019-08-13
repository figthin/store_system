package com.hwua.storesystem;

import com.hwua.storesystem.entity.Permission;
import com.hwua.storesystem.entity.Role;
import com.hwua.storesystem.mapper.ManagerMapper;
import com.hwua.storesystem.mapper.PermissionMapper;
import com.hwua.storesystem.mapper.RoleMapper;
import com.hwua.storesystem.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StoreSystemApplicationTests {


    @Autowired
    private PermissionMapper permissionMapper;

    private Logger logger = LoggerFactory.getLogger(StoreSystemApplicationTests.class);
    @Test
    public void contextLoads() {

        String tom123456 = MD5Util.getMd5("tom123456");
        logger.debug("密码："+tom123456);
    }

}
