package com.wubing.test;

import com.wubing.learn.config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Bean生命周期测试
 *
 * @author: WB
 * @version: v1.0
 */
public class SpringLifecycleTest {
	public static void main(String[] args) {
		System.out.println("现在开始初始化 Spring 容器");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.wubing.learn.config");
		System.out.println("\t\n容器初始化成功");

		//得到Person并开始使用
		System.out.println("\t\n具体业务调用开始");
//        Person person = context.getBean("person", Person.class);
//        System.out.println(person);

//        UserService userService = context.getBean("userService", UserService.class);
//        userService.doTestDao();

		System.out.println("具体业务调用结束，准备关闭容器！\t\n");

		System.out.println("现在开始关闭容器");
		context.registerShutdownHook();
	}

}
