package com.guanjian.jigsaw.spring.parser;

import com.guanjian.jigsaw.bean.material.Photo;
import com.guanjian.jigsaw.bean.material.Text;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * created by guanjian on 2019/8/27 9:11
 */
public class PhotoBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return Photo.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        final String id = element.getAttribute("id");
        final String path = element.getAttribute("path");

        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        }
        if (StringUtils.hasText(path)) {
            builder.addPropertyValue("path", path);
        }
    }
}
