package com.guanjian.jigsaw.test;

import com.guanjian.jigsaw.bean.layout.Layer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring-config.xml")
public class ConfigReaderTest implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (ConfigReaderTest.applicationContext == null) {
            ConfigReaderTest.applicationContext = applicationContext;
        }
    }

    @Test
    public void test() {
        Layer layer = (Layer) applicationContext.getBean("layoutDemo");
        System.out.println(layer.getSpecs());
        System.out.println(layer.getMaterial());
        System.out.println(layer.getIndex());
    }
}