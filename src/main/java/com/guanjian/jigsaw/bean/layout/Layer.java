package com.guanjian.jigsaw.bean.layout;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;

/**
 * 图层
 *
 * @author guanjian
 * @description
 * @date 2019/6/12 20:14
 */
public class Layer {
    private String id;         //id
    private String material;   //素材
    private String specs;      //规格
    private Integer index;     //堆叠顺序

    private Layer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getSpecs() {
        return specs;
    }

    public void setSpecs(String specs) {
        this.specs = specs;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
