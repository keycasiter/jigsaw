package com.guanjian.jigsaw.test;

import com.guanjian.jigsaw.spring.bean.TextBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

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
        System.out.println(Arrays.toString(applicationContext.getBeanDefinitionNames()));
        TextBean textBean = (TextBean) applicationContext.getBean("text1");
        System.out.println(textBean.getSize());
        System.out.println(textBean.getFormat());
        System.out.println(textBean.getRgbColor());
        System.out.println(textBean.getText());
        System.out.println(textBean.getId());
    }

    public static void main(String[] args) {

    }
}