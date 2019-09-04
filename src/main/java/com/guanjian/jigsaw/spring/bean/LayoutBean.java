package com.guanjian.jigsaw.spring.bean;

import java.io.Serializable;
import java.util.List;

/**
 * created by guanjian on 2019/8/28 13:22
 */
public class LayoutBean implements Serializable {

    private static final long serialVersionUID = 1851454407580244706L;

    /**
     * 标识id
     */
    private String id;
    /**
     * 高度
     */
    private int height;
    /**
     * 宽度
     */
    private int width;
    /**
     * 图层
     */
    private List<LayerBean> layers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public List<LayerBean> getLayers() {
        return layers;
    }

    public void setLayers(List<LayerBean> layers) {
        this.layers = layers;
    }
}
