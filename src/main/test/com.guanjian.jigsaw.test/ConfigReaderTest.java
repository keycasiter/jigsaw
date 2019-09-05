package com.guanjian.jigsaw.test;

import com.guanjian.jigsaw.service.GraphicsFactory;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void test01() {
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

    @Test
    public void test02(){
        GraphicsFactory gf = GraphicsFactory.getInstance();

        List<LayerBean> layerBeanList = new ArrayList<LayerBean>();
        LayerBean layer = new LayerBean();
        layer.setId("layer1");
        layerBeanList.add(layer);

        long start = System.currentTimeMillis();
        gf.produce(layerBeanList);
        long end = System.currentTimeMillis();
        System.out.println(String.format("消耗时间 %s ms", end - start));
    }

    public static void main(String[] args) {

    }
}