package com.guanjian.jigsaw.spring.parser;

import com.guanjian.jigsaw.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import java.lang.reflect.Method;

/**
 * BeanDefinition解析器
 *
 * created by guanjian on 2019/8/27 9:11
 */
public class JigsawBeanDefinitionParser implements BeanDefinitionParser {

    /**
     * LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(JigsawBeanDefinitionParser.class);

    /**
     * 解析Class
     */
    private transient Class<?> beanClazz;

    public JigsawBeanDefinitionParser(Class<?> beanClazz) {
        this.beanClazz = beanClazz;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition(beanClazz);

        for (Method method : beanClazz.getDeclaredMethods()) {
            String methodName = method.getName();

            if (!"get".equals(methodName.substring(0, 3).toLowerCase())) continue;

            String propertyName = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);

            parseLayout(element, beanDefinition, propertyName);
            parseLayer(element, beanDefinition, propertyName);
            parseText(element, beanDefinition, propertyName);
            parseImage(element, beanDefinition, propertyName);

        }

        parserContext.getRegistry().registerBeanDefinition(element.getAttribute("id"), beanDefinition);

        return beanDefinition;
    }

    private void parseLayout(Element element, BeanDefinition beanDefinition, String propertyName) {
        //layout
        if (element.getLocalName().equals("layout")) {
            String propertyValue = element.getAttribute(propertyName);
            //处理list
            if (propertyName.equals("layers")) {
                ManagedList list = new ManagedList();
                if (propertyValue.contains(Constants.Global.COMMA)) {
                    String[] layerIds = propertyValue.split(Constants.Global.COMMA);
                    for (String layerId : layerIds) {
                        list.add(new RuntimeBeanReference(layerId));
                    }
                } else {
                    list.add(new RuntimeBeanReference(propertyValue));
                }
                beanDefinition.getPropertyValues().addPropertyValue(propertyName, list);
            } else {
                //处理基础类型字段
                beanDefinition.getPropertyValues().addPropertyValue(propertyName, propertyValue);
            }
        }
    }

    private void parseLayer(Element element, BeanDefinition beanDefinition, String propertyName) {
        //layer
        if (element.getLocalName().equals("layer")) {
            String propertyValue = element.getAttribute(propertyName);
            //处理对象
            if (propertyName.equals("material")) {
                beanDefinition.getPropertyValues().addPropertyValue(propertyName, new RuntimeBeanReference(propertyValue));
            } else {
                //处理基础类型字段
                beanDefinition.getPropertyValues().addPropertyValue(propertyName, propertyValue);
            }
        }
    }

    private void parseText(Element element, BeanDefinition beanDefinition, String propertyName) {
        //text
        if (element.getLocalName().equals("text")) {
            String propertyValue = element.getAttribute(propertyName);
            //处理基础类型字段
            beanDefinition.getPropertyValues().addPropertyValue(propertyName, propertyValue);
        }
    }

    private void parseImage(Element element, BeanDefinition beanDefinition, String propertyName) {
        //image
        if (element.getLocalName().equals("image")) {
            String propertyValue = element.getAttribute(propertyName);
            //处理基础类型字段
            beanDefinition.getPropertyValues().addPropertyValue(propertyName, propertyValue);
        }
    }
}
