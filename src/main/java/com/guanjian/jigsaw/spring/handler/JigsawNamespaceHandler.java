package com.guanjian.jigsaw.spring.handler;

import com.guanjian.jigsaw.spring.parser.*;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * created by guanjian on 2019/8/27 9:09
 */
public class JigsawNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("panel", new PanelBeanDefinitionParser());
        registerBeanDefinitionParser("photo", new PhotoBeanDefinitionParser());
        registerBeanDefinitionParser("text", new TextBeanDefinitionParser());
        registerBeanDefinitionParser("element", new ElementBeanDefinitionParser());
        registerBeanDefinitionParser("layer", new LayerBeanDefinitionParser());
    }
}
