package com.guanjian.jigsaw.spring.parser;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * created by guanjian on 2019/8/27 9:11
 */
public class ElementBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return com.guanjian.jigsaw.bean.specs.Element.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {

        final String id = element.getAttribute("id");
        final String width = element.getAttribute("width");
        final String height = element.getAttribute("height");
        final String coordinateX = element.getAttribute("coordinateX");
        final String coordinateY = element.getAttribute("coordinateY");

        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        }
        if (StringUtils.hasText(width)) {
            builder.addPropertyValue("width", Integer.valueOf(width));
        }
        if (StringUtils.hasText(height)) {
            builder.addPropertyValue("height", Integer.valueOf(height));
        }
        if (StringUtils.hasText(coordinateX)) {
            builder.addPropertyValue("coordinateX", Integer.valueOf(coordinateX));
        }
        if (StringUtils.hasText(coordinateY)) {
            builder.addPropertyValue("coordinateY", Integer.valueOf(coordinateY));
        }
    }
}
