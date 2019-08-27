package com.guanjian.jigsaw.spring.parser;

import com.guanjian.jigsaw.bean.layout.Layer;
import com.guanjian.jigsaw.bean.material.Text;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

/**
 * created by guanjian on 2019/8/27 9:11
 */
public class TextBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return Text.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        final String id = element.getAttribute("id");
        final String rgbColor = element.getAttribute("rgbColor");
        final String fontSize = element.getAttribute("fontSize");
        final String fontText = element.getAttribute("fontText");
        final String fontFormat = element.getAttribute("fontFormat");

        if (StringUtils.hasText(id)) {
            builder.addPropertyValue("id", id);
        }
        if (StringUtils.hasText(rgbColor)) {
            builder.addPropertyValue("rgbColor", rgbColor);
        }
        if (StringUtils.hasText(fontSize)) {
            builder.addPropertyValue("fontSize", fontSize);
        }
        if (StringUtils.hasText(fontText)) {
            builder.addPropertyValue("fontText", fontText);
        }
        if (StringUtils.hasText(fontFormat)) {
            builder.addPropertyValue("fontFormat", fontFormat);
        }
    }
}
