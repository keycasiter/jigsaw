package com.guanjian.jigsaw.spring.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.lang.reflect.Method;

/**
 * created by guanjian on 2019/8/27 9:11
 */
public class JigsawBeanDefinitionParser implements BeanDefinitionParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(JigsawBeanDefinitionParser.class);

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

            if (element.getLocalName().equals("layout")) {
                String propertyValue = element.getAttribute(propertyName);
                NodeList nodeList = element.getChildNodes();
                ManagedList list = new ManagedList();
                for (int i = 0; i < nodeList.getLength(); i++) {
                    if (nodeList.item(i).getLocalName().equals("panel")) {
                        beanDefinition.getPropertyValues().addPropertyValue(propertyName, new RuntimeBeanReference(propertyValue));
                    }
                    if (nodeList.item(i).getLocalName().equals("layer")) {
                        list.add(new RuntimeBeanReference(propertyValue));
                        beanDefinition.getPropertyValues().addPropertyValue(propertyName, list);
                    }
                }
            }
            if (element.getLocalName().equals("panel")) {

            }
            if (element.getLocalName().equals("layer")) {

            }
            if (element.getLocalName().equals("text")) {

            }
            if (element.getLocalName().equals("image")) {

            }

        }

        parserContext.getRegistry().registerBeanDefinition(element.getAttribute("id"), beanDefinition);

        return beanDefinition;
    }

    private void addPropertyValue(BeanDefinition beanDefinition, String propertyName, String propertyValue) {
        if (propertyName.equals("panel")) {
            beanDefinition.getPropertyValues().addPropertyValue(propertyName, new RuntimeBeanReference(propertyValue));
        }
        if (propertyName.equals("layer")) {

        }
        beanDefinition.getPropertyValues().addPropertyValue(propertyName, propertyValue);
    }

}
