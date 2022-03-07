package com.wubing.learn.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义BeanFactoryPostProcessor接口实例
 * 演示Bean工厂后处理器接口方法
 *
 * @author: WB
 * @version: v1.0
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    public MyBeanFactoryPostProcessor() {
        super();
        System.out.println("这是BeanFactoryPostProcessor实现类构造器！！");
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor调用postProcessBeanFactory方法：并修改person的属性值");

        /**
         * 通过BeanFactoryProcessor对调用postProcessBeanFactory
         * 对BeanFactory中的BeanDefinition进行增强
         * 设置属性值，预置并未立即执行，且需要属性提供对应的setter方法
         */
        BeanDefinition bd = beanFactory.getBeanDefinition("person");
        bd.getPropertyValues().addPropertyValue("name", "lisi");
        bd.getPropertyValues().addPropertyValue("address", "guangzhou");
        bd.getPropertyValues().addPropertyValue("phone", "110");

        BeanDefinition bd2 = beanFactory.getBeanDefinition("ADemo");
        bd2.getPropertyValues().addPropertyValue("name", "aDemo");
    }
}
