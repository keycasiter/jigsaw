package com.guanjian.jigsaw.spring.bean;

import com.guanjian.jigsaw.bean.layout.Layer;
import com.guanjian.jigsaw.bean.material.Photo;
import com.guanjian.jigsaw.bean.material.Text;
import com.guanjian.jigsaw.bean.specs.Element;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * created by guanjian on 2019/8/27 17:34
 */
public class JigsawBeanDefinitionRegistry implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry beanDefinitionRegistry) throws BeansException {
        //register bean definition
        RootBeanDefinition layerBeanDefinition = new RootBeanDefinition(Layer.class);
        RootBeanDefinition photoBeanDefinition = new RootBeanDefinition(Photo.class);
        RootBeanDefinition textBeanDefinition = new RootBeanDefinition(Text.class);
        RootBeanDefinition elementBeanDefinition = new RootBeanDefinition(Element.class);

        beanDefinitionRegistry.registerBeanDefinition("layer", layerBeanDefinition);
        beanDefinitionRegistry.registerBeanDefinition("photo", photoBeanDefinition);
        beanDefinitionRegistry.registerBeanDefinition("text", textBeanDefinition);
        beanDefinitionRegistry.registerBeanDefinition("element", elementBeanDefinition);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    }
}
