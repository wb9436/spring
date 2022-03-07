package com.wubing.learn.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试循环依赖
 *
 * @author: WB
 * @version: v1.0
 */
@Service
public class BDemo {

    @Autowired
    private CDemo cDemo;
    @Autowired
    private ADemo aDemo;

    public BDemo() {
        System.out.println("【构造器】调用BDemo的构造器实例化");
    }
}
