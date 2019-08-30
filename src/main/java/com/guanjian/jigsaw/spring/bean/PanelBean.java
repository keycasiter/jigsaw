package com.guanjian.jigsaw.spring.bean;

import java.io.Serializable;

/**
 * created by guanjian on 2019/8/28 9:56
 */
public class PanelBean implements Serializable {

    private static final long serialVersionUID = 5639450153336902191L;

    /**
     * id标识
     */
    private String id;
    /**
     * 宽度
     */
    private Integer width;
    /**
     * 高度
     */
    private Integer height;

    public PanelBean() {
    }

    public PanelBean(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
