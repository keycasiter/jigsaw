package com.guanjian.jigsaw.spring.registry;

import com.guanjian.jigsaw.spring.bean.*;
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
        //register registry definition
        beanDefinitionRegistry.registerBeanDefinition("layer", new RootBeanDefinition(LayerBean.class));
        beanDefinitionRegistry.registerBeanDefinition("photo", new RootBeanDefinition(ImageBean.class));
        beanDefinitionRegistry.registerBeanDefinition("text", new RootBeanDefinition(TextBean.class));
        beanDefinitionRegistry.registerBeanDefinition("panel", new RootBeanDefinition(PanelBean.class));
        beanDefinitionRegistry.registerBeanDefinition("layout", new RootBeanDefinition(LayoutBean.class));
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
    }
}
