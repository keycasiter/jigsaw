package com.guanjian.jigsaw.spring.parser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.lang.reflect.Method;

/**
 * created by guanjian on 2019/8/27 9:11
 */
public class BeanDefinitionParser implements org.springframework.beans.factory.xml.BeanDefinitionParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(BeanDefinitionParser.class);

    private transient String beanName;

    private transient Class<?> beanClazz;


    public BeanDefinitionParser(String beanName, Class<?> beanClazz) {
        this.beanName = beanName;
        this.beanClazz = beanClazz;
    }

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClassName(beanName);
        beanDefinition.setBeanClass(beanClazz);

        for (Method method : beanClazz.getMethods()){
           String methodName = method.getName();
           String property = methodName.substring(3,4).toLowerCase() + methodName.substring(4);
        }

        NodeList nodeList = element.getChildNodes();

        if (null != nodeList && nodeList.getLength() > 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    if ("panel".equals(node.getLocalName())) {
                        parsePanel(beanDefinition, node);
                    }
                    if ("layer".equals(node.getLocalName())) {
                        parseLayer(beanDefinition, node);
                    }
                }
            }
        }

        return beanDefinition;
    }

    private void parsePanel(BeanDefinition beanDefinition, Node node) {
        String id = ((Element) node).getAttribute("id");
        beanDefinition.getPropertyValues().addPropertyValue("id", id);
        String height = ((Element) node).getAttribute("height");
        beanDefinition.getPropertyValues().addPropertyValue("height", height);
        String weight = ((Element) node).getAttribute("weight");
        beanDefinition.getPropertyValues().addPropertyValue("weight", weight);
    }

    private void parseLayer(BeanDefinition beanDefinition, Node node) {
        String id = ((Element) node).getAttribute("id");
        beanDefinition.getPropertyValues().addPropertyValue("id", id);
        String height = ((Element) node).getAttribute("height");
        beanDefinition.getPropertyValues().addPropertyValue("height", height);
        String weight = ((Element) node).getAttribute("weight");
        beanDefinition.getPropertyValues().addPropertyValue("weight", weight);
        String coordinateX = ((Element) node).getAttribute("coordinateX");
        beanDefinition.getPropertyValues().addPropertyValue("coordinateX", coordinateX);
        String coordinateY = ((Element) node).getAttribute("coordinateY");
        beanDefinition.getPropertyValues().addPropertyValue("coordinateY", coordinateY);
        String coordinateZ = ((Element) node).getAttribute("coordinateZ");
        beanDefinition.getPropertyValues().addPropertyValue("coordinateZ", coordinateZ);

        if (null == node.getChildNodes()) return;

        NodeList nodeList = node.getChildNodes();
        if (null != nodeList && nodeList.getLength() > 0) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node childNode = nodeList.item(i);
                if (childNode instanceof Element) {
                    if ("image".equals(childNode.getNodeName())) {
                        parseImage(beanDefinition, childNode);
                    }
                    if ("text".equals(childNode.getNodeName())) {
                        parseText(beanDefinition, childNode);
                    }
                }
            }
        }
    }

    private void parseImage(BeanDefinition beanDefinition, Node node) {
        String id = ((Element) node).getAttribute("id");
        beanDefinition.getPropertyValues().addPropertyValue("id", id);
        String path = ((Element) node).getAttribute("path");
        beanDefinition.getPropertyValues().addPropertyValue("path", path);
    }

    private void parseText(BeanDefinition beanDefinition, Node node) {
        String id = ((Element) node).getAttribute("id");
        beanDefinition.getPropertyValues().addPropertyValue("id", id);
        String rgbColor = ((Element) node).getAttribute("rgbColor");
        beanDefinition.getPropertyValues().addPropertyValue("rgbColor", rgbColor);
        String fontText = ((Element) node).getAttribute("fontText");
        beanDefinition.getPropertyValues().addPropertyValue("fontText", fontText);
        String fontSize = ((Element) node).getAttribute("fontSize");
        beanDefinition.getPropertyValues().addPropertyValue("fontSize", fontSize);
        String fontFormat = ((Element) node).getAttribute("fontFormat");
        beanDefinition.getPropertyValues().addPropertyValue("fontFormat", fontFormat);
    }
}
