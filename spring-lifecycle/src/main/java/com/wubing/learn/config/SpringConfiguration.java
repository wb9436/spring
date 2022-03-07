package com.wubing.learn.config;

import com.wubing.learn.lifecycle.Person;
import com.wubing.learn.support.factorys.MyPropertySourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring配置类
 *
 * @author: WB
 * @version: v1.0
 */
@Configuration
@ComponentScan(value = "com.wubing.learn")
@PropertySource(value = "config.yml", encoding = "UTF-8", factory = MyPropertySourceFactory.class)
public class SpringConfiguration {

    public SpringConfiguration() {
        System.out.println("\t\n【构造器】调用SpringConfig的构造器实例化");
    }

    @Bean(initMethod = "myInit", destroyMethod = "myDestroy")
    public Person person() {
        return new Person();
    }
}
