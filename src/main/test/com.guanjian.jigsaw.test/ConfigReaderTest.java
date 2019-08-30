package com.guanjian.jigsaw.test;

import com.guanjian.jigsaw.spring.bean.LayoutBean;
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
        LayoutBean layout1 = (LayoutBean) applicationContext.getBean("layout1");
        System.out.println(layout1.getId());
    }
}