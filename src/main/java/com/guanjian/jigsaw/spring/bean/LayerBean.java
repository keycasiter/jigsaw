package com.guanjian.jigsaw.spring.bean;

import java.io.Serializable;

/**
 * 图层
 *
 * @author guanjian
 * @description
 * @date 2019/6/12 20:14
 */
public class LayerBean implements Serializable {

    private static final long serialVersionUID = -2566496464872410684L;

    /**
     * 标识id
     */
    private String id;
    /**
     * 长度
     */
    private Integer height;
    /**
     * 宽度
     */
    private Integer width;
    /**
     * x轴
     */
    private Integer coordinateX;
    /**
     * y轴
     */
    private Integer coordinateY;
    /**
     * z轴
     */
    private Integer coordinateZ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(Integer coordinateX) {
        this.coordinateX = coordinateX;
    }

    public Integer getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(Integer coordinateY) {
        this.coordinateY = coordinateY;
    }

    public Integer getCoordinateZ() {
        return coordinateZ;
    }

    public void setCoordinateZ(Integer coordinateZ) {
        this.coordinateZ = coordinateZ;
    }
}
