package com.wubing.learn.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 测试循环依赖
 *
 * @author: WB
 * @version: v1.0
 */
@Service
public class CDemo {

    /**
     * 方便观察BeanFactory的缓存变化
     */
    @Autowired
    private ApplicationContext applicationContext;

    public CDemo() {
        System.out.println("【构造器】调用CDemo的构造器实例化");
    }
}
