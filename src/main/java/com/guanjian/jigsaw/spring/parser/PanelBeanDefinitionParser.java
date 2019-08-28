package com.guanjian.jigsaw.spring.parser;

import com.guanjian.jigsaw.bean.layout.Panel;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * created by guanjian on 2019/8/27 9:11
 */
public class PanelBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return Panel.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {

        final String id = element.getAttribute("id");
        final String width = element.getAttribute("width");
        final String height = element.getAttribute("height");

        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        }
        if (StringUtils.hasText(width)) {
            builder.addPropertyValue("width", Integer.valueOf(width));
        }
        if (StringUtils.hasText(height)) {
            builder.addPropertyValue("height", Integer.valueOf(height));
        }
    }
}
