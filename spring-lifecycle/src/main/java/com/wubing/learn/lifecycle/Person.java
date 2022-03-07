package com.wubing.learn.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;

/**
 * @author: WB
 * @version: v1.0
 */
public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    /**
     * 方便观察BeanFactory的缓存变化
     */
    @Autowired
    private ApplicationContext applicationContext;

    /**
     * 注解@Value为属性设置值，不需要bean提供setter方法
     */
    @Value("${person.name}")
    private String name;
    @Value("${person.address}")
    private String address;
    @Value("${person.phone}")
    private String phone;

    private BeanFactory beanFactory;
    private String beanName;

    public Person() {
        System.out.println("【构造器】调用Person的构造器实例化");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("【Person 注入属性】注入属性name：oldVal=" + this.name + "; newVal=" + name);
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        System.out.println("【Person 注入属性】注入属性address：oldVal=" + this.address + "; newVal=" + address);
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        System.out.println("【Person 注入属性】注入属性phone：oldVal=" + this.phone + "; newVal=" + phone);
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person [address=" + address + ", name=" + name + ", phone="
                + phone + "]";
    }

    /**
     * BeanFactoryAware接口方法
     *
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    /**
     * BeanNameAware接口方法
     *
     * @param beanName
     */
    @Override
    public void setBeanName(String beanName) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanName = beanName;
    }

    /**
     * InitializingBean接口方法
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    /**
     * DisposableBean接口方法
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {
        System.out.println("【DisposableBean接口】调用DisposableBean接口.destroy()销毁方法");
    }

    /**
     * 通过<bean>的init-method属性指定的初始化方法
     */
    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的myInit初始化方法");
    }

    /**
     * 通过<bean>的destroy-method属性指定的初始化方法
     */
    public void myDestroy() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的myDestroy销毁方法");
    }

}
