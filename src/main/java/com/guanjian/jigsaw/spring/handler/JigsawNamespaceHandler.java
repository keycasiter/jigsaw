package com.guanjian.jigsaw.spring.handler;

import com.guanjian.jigsaw.spring.bean.LayoutBean;
import com.guanjian.jigsaw.spring.parser.BeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * created by guanjian on 2019/8/27 9:09
 */
public class JigsawNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("layout", new BeanDefinitionParser("layout", LayoutBean.class));
    }
}
