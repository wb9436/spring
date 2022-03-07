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
public class ADemo {

    private String name;
    @Autowired
    private BDemo bDemo;

    public ADemo() {
        System.out.println("【构造器】调用ADemo的构造器实例化");
    }

    public void setName(String name) {
        System.out.println("【ADemo 注入属性】注入属性name：oldVal=" + this.name + "; newVal=" + name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "ADemo [name=" + name + ", bDemo=" + bDemo + "]";
    }
}
