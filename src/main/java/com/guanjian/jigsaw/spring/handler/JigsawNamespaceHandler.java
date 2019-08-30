package com.guanjian.jigsaw.spring.handler;

import com.guanjian.jigsaw.spring.bean.*;
import com.guanjian.jigsaw.spring.parser.JigsawBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * created by guanjian on 2019/8/27 9:09
 */
public class JigsawNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("text", new JigsawBeanDefinitionParser(TextBean.class));
        registerBeanDefinitionParser("image", new JigsawBeanDefinitionParser(ImageBean.class));
        registerBeanDefinitionParser("panel", new JigsawBeanDefinitionParser(PanelBean.class));
        registerBeanDefinitionParser("layer", new JigsawBeanDefinitionParser(LayerBean.class));
        registerBeanDefinitionParser("layout", new JigsawBeanDefinitionParser(LayoutBean.class));
    }
}
