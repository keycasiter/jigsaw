package com.guanjian.jigsaw.spring.parser;

import com.guanjian.jigsaw.bean.layout.Layer;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * created by guanjian on 2019/8/27 9:11
 */
public class LayerBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {

    @Override
    protected Class<?> getBeanClass(Element element) {
        return Layer.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {

        final String id = element.getAttribute("id");
        final String material = element.getAttribute("material");
        final String specs = element.getAttribute("specs");
        final String index = element.getAttribute("index");

        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        }
        if (StringUtils.hasText(material)) {
            builder.addPropertyValue("material", material);
        }
        if (StringUtils.hasText(specs)) {
            builder.addPropertyValue("specs", specs);
        }
        if (StringUtils.hasText(index)) {
            builder.addPropertyValue("index", Integer.valueOf(index));
        }
    }
}
