package com.guanjian.jigsaw.spring.handler;

import com.guanjian.jigsaw.spring.parser.ElementBeanDefinitionParser;
import com.guanjian.jigsaw.spring.parser.LayerBeanDefinitionParser;
import com.guanjian.jigsaw.spring.parser.TextBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * created by guanjian on 2019/8/27 9:09
 */
public class JigsawNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("text", new TextBeanDefinitionParser());
        registerBeanDefinitionParser("element", new ElementBeanDefinitionParser());
        registerBeanDefinitionParser("layout", new LayerBeanDefinitionParser());
    }
}
