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

    private String id;         //id
    private Material materialId;   //素材对象
    private Integer height;//长度
    private Integer width;//宽度
    private Integer coordinateX;  //x轴
    private Integer coordinateY;  //y轴
    private Integer coordinateZ;  //z轴

    public LayerBean() {
    }

    public LayerBean(String id, com.guanjian.jigsaw.spring.bean.Material materialId, Integer height, Integer width, Integer coordinateX, Integer coordinateY, Integer coordinateZ) {
        this.id = id;
        this.materialId = materialId;
        this.height = height;
        this.width = width;
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.coordinateZ = coordinateZ;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Material getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Material materialId) {
        this.materialId = materialId;
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
