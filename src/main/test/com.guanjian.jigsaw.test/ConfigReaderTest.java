package com.guanjian.jigsaw.test;

import com.guanjian.jigsaw.bean.layout.Layer;
import com.guanjian.jigsaw.bean.layout.Panel;
import com.guanjian.jigsaw.bean.material.Photo;
import com.guanjian.jigsaw.bean.material.Text;
import com.guanjian.jigsaw.bean.specs.Element;
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
        Panel panel = (Panel) applicationContext.getBean("panelDemo");
        Text text = (Text) applicationContext.getBean("textDemo");
        Photo photo = (Photo) applicationContext.getBean("photoDemo");
        Element element = (Element) applicationContext.getBean("elementDemo");
        Layer layer = (Layer) applicationContext.getBean("layerDemo");
        System.out.println(panel.getId());
        System.out.println(text.getId());
        System.out.println(photo.getId());
        System.out.println(element.getId());
        System.out.println(layer.getId());
        System.out.println(((Photo)layer.getMaterialRef()).getId());
    }
}