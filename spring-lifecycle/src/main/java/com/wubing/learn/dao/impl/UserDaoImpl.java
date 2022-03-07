package com.wubing.learn.dao.impl;

import com.wubing.learn.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @author: WB
 * @version: v1.0
 */
//@Repository
public class UserDaoImpl implements UserDao {
    @Override
    public void doTestUserDao() {
        System.out.println("this is userDao");
    }
}
