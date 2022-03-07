package com.wubing.learn.support.factorys;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * 自定义配置文件解析工厂
 *
 * @author: WB
 * @version: v1.0
 */
public class MyPropertySourceFactory implements PropertySourceFactory {

    public MyPropertySourceFactory() {
        super();
        System.out.println("这是PropertySourceFactory实现类自定义文件解析工厂类！！");
    }

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        //1.Yaml文件工厂
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        //2.设置文件资源数据
        factoryBean.setResources(resource.getResource());
        //3.获取Properties对象
        Properties properties = factoryBean.getObject();

        System.out.println("自定义解析工厂类完成yml配置文件解析\t\n");
        return (name != null ? new PropertiesPropertySource(name, properties)
                : new PropertiesPropertySource(resource.getResource().getFilename(), properties));
    }
}
