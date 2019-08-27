package com.guanjian.jigsaw.bean.specs;

/**
 * @author guanjian
 * @description
 * @date 2019/6/14 10:39
 */
public class Element {
    private String id;     //id
    private Integer height;//长度
    private Integer width;//宽度
    private Integer coordinateX;  //x轴
    private Integer coordinateY;  //y轴

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
}
