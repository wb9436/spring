package com.wubing.learn.bean;

import com.wubing.learn.lifecycle.Person;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author: WB
 * @version: v1.0
 */
@Component
public class PersonFactoryBean implements FactoryBean<Person> {

    @Override
    public boolean isSingleton() {
        return true;
    }

    @Override
    public Person getObject() throws Exception {
        Person person = new Person();
        /**/
        System.out.println("this is person FactoryBean");
        return person;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }
}
