package com.guanjian.jigsaw.spring.handler;

import com.guanjian.jigsaw.spring.bean.ImageBean;
import com.guanjian.jigsaw.spring.bean.LayerBean;
import com.guanjian.jigsaw.spring.bean.LayoutBean;
import com.guanjian.jigsaw.spring.bean.TextBean;
import com.guanjian.jigsaw.spring.parser.JigsawBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * 注册BeanDefinition解析器
 *
 * created by guanjian on 2019/8/27 9:09
 */
public class JigsawNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("text", new JigsawBeanDefinitionParser(TextBean.class));
        registerBeanDefinitionParser("image", new JigsawBeanDefinitionParser(ImageBean.class));
        registerBeanDefinitionParser("layer", new JigsawBeanDefinitionParser(LayerBean.class));
        registerBeanDefinitionParser("layout", new JigsawBeanDefinitionParser(LayoutBean.class));
    }
}
