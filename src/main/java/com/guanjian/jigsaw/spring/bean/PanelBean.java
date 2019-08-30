package com.guanjian.jigsaw.spring.bean;

import java.io.Serializable;

/**
 * created by guanjian on 2019/8/28 9:56
 */
public class PanelBean implements Serializable {

    private static final long serialVersionUID = 5639450153336902191L;

    private String id;
    private Integer width;
    private Integer height;

    public PanelBean() {
    }

    public PanelBean(String id, Integer width, Integer height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
