package com.wubing.learn.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessorAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

/**
 * 自定义InstantiationAwareBeanPostProcessor
 * 演示InstantiationAwareBeanPostProcessor后处理器方法
 * 这是对BeanPostProcessor的增强
 *
 * @author: WB
 * @version: v1.0
 */
@Component
public class MyInstantiationAwareBeanPostProcessor extends InstantiationAwareBeanPostProcessorAdapter {

    /**
     * 方便观察BeanFactory的缓存变化
     */
    @Autowired
    private ApplicationContext applicationContext;

    public MyInstantiationAwareBeanPostProcessor() {
        super();
        System.out.println("这是InstantiationAwareBeanPostProcessorAdapter实现类构造器！！");
    }

    @Override
    public Class<?> predictBeanType(Class<?> beanClass, String beanName) throws BeansException {
        return super.predictBeanType(beanClass, beanName);
    }

    @Override
    public Constructor<?>[] determineCandidateConstructors(Class<?> beanClass, String beanName) throws BeansException {
        return super.determineCandidateConstructors(beanClass, beanName);
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        return super.getEarlyBeanReference(bean, beanName);
    }

    /**
     * 接口方法、实例化Bean之前调用
     * 调用构造函数实例化对象方法之前
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("\t\n【" + beanName + "】开始初始化");
        System.out.println("【Bean后置增强器 postProcessBeforeInstantiation】调用" + beanName + "的构造器【实例化】之【前】调用：beanClass=" + beanClass);
        return super.postProcessBeforeInstantiation(beanClass, beanName);
    }

    /**
     * 接口方法、实例化Bean之后调用
     * 调用构造函数实例化对象方法之后
     */
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.println("【Bean后置增强器 postProcessAfterInstantiation】调用" + beanName + "的构造器【实例化】之【后】调用：bean=" + bean);
        return super.postProcessAfterInstantiation(bean, beanName);
    }


    /**
     * 接口方法、设置某个属性时调用
     */
    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        System.out.println("【Bean后置增强器 postProcessProperties】调用postProcessProperties方法: pvs=" + pvs + "; bean=" + bean);
        return pvs;
    }

    /**
     * 接口方法、初始化Bean之前调用
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【Bean后置增强器 postProcessBeforeInitialization】【初始化】之【前】调用：bean=" + bean);
        return bean;
    }

    /**
     * 接口方法、初始化Bean之后调用
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("【Bean后置增强器 postProcessAfterInitialization】【初始化】之【后】调用：bean=" + bean);
        System.out.println("【" + beanName + "】结束初始化\t\n");
        return bean;
    }
}
