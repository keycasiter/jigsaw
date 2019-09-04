package com.guanjian.jigsaw.test;

import com.guanjian.jigsaw.spring.bean.LayerBean;
import com.guanjian.jigsaw.spring.bean.LayoutBean;
import com.guanjian.jigsaw.spring.bean.TextBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.xml.soap.Text;
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
        for (String name : applicationContext.getBeanDefinitionNames()){
            System.out.printf("%s \n",name);
        }
        LayoutBean layout = (LayoutBean) applicationContext.getBean("layout");
        LayerBean layer1 = (LayerBean) applicationContext.getBean("layer1");
        System.out.println(layout.getId());
        System.out.println(layout.getWidth());
        System.out.println(layout.getHeight());
        System.out.println(layout.getLayers().size());
        LayerBean layerBean = (LayerBean) layout.getLayers().get(0);
        System.out.println(layerBean.getId());
        TextBean textBean = (TextBean) layerBean.getMaterial();
        System.out.println(textBean.getId());
        System.out.println(textBean.getRgbColor());
    }

    public static void main(String[] args) {

    }
}