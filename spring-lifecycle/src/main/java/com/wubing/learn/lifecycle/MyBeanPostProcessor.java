package com.wubing.learn.lifecycle;

import com.wubing.learn.annotation.RoutingInjected;
import com.wubing.learn.support.factorys.RoutingBeanFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 自定义BeanPostProcessor接口实例
 * 演示Bean后处理器接口方法
 * <p>
 * BeanPostProcessor接口的作用是：
 * 我们可以通过该接口中的方法在bean实例化、配置以及其他初始化方法前后添加一些我们自己的逻辑
 *
 * @author: WB
 * @version: v1.0
 */
//@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;

    public MyBeanPostProcessor() {
        super();
        System.out.println("这是BeanPostProcessor实现类构造器！！");
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessBeforeInitialization！bean=" + bean
                + "; 在实例化、依赖注入完毕，初始化之前执行！");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor接口方法postProcessAfterInitialization！bean=" + bean
                + "; 在实例化、依赖注入完毕，初始化之后执行！");
        /*定制自己的逻辑处理*/
        Class<?> targetCls = bean.getClass();
        Field[] targetFld = targetCls.getDeclaredFields();

        /*校验@RoutingInjected注解的属性是否是接口*/
        for (Field field : targetFld) {
            //找到制定目标的注解类
            if (field.isAnnotationPresent(RoutingInjected.class)) {
                if (!field.getType().isInterface()) {
                    throw new BeanCreationException("RoutingInjected field must be declared as an interface:" + field.getName()
                            + " @Class " + targetCls.getName());
                }
            }
        }
        /*校验自定义注解RoutingInjected的使用是否正确，并完成依赖注入*/
        /*Class<?> targetCls = bean.getClass();
        Field[] targetFld = targetCls.getDeclaredFields();
        for (Field field : targetFld) {
            //找到制定目标的注解类
            if (field.isAnnotationPresent(RoutingInjected.class)) {
                if (!field.getType().isInterface()) {
                    throw new BeanCreationException("RoutingInjected field must be declared as an interface:" + field.getName()
                            + " @Class " + targetCls.getName());
                }
                try {
                    this.handleRoutingInjected(field, bean, field.getType(), field.getName());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }*/
        return bean;
    }

    /**
     * 实现依赖注入
     */
    private void handleRoutingInjected(Field field, Object bean, Class<Object> type, String name) throws IllegalAccessException {
        Map<String, Object> candidates = this.applicationContext.getBeansOfType(type);
        field.setAccessible(true);
        if (candidates.size() == 1) {
            field.set(bean, candidates.values().iterator().next());
        } else if (candidates.size() == 2) {
            Object proxy = RoutingBeanFactory.createProxy(type, name, candidates);
            field.set(bean, proxy);
        } else {
            throw new IllegalArgumentException("Find more than 2 beans for type: " + type);
        }
    }
}
