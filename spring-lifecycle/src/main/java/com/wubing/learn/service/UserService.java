package com.wubing.learn.service;

import com.wubing.learn.annotation.RoutingInjected;
import com.wubing.learn.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: WB
 * @version: v1.0
 */
//@Service
public class UserService {

//    @RoutingInjected
//    @Autowired
    private UserDao userDao;

    public UserService() {
        System.out.println("【构造器】调用UserService的构造器实例化");
    }

    public void doTestDao() {
        userDao.doTestUserDao();
    }


    @Override
    public String toString() {
        return "UserService{" +
                "userDao=" + userDao +
                '}';
    }
}
