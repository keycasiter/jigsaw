package com.guanjian.jigsaw.bean.layout;

import com.guanjian.jigsaw.bean.material.Material;
import com.guanjian.jigsaw.bean.specs.Specs;

/**
 * 图层
 *
 * @author guanjian
 * @description
 * @date 2019/6/12 20:14
 */
public class Layer {
    private String id;         //id
    private Material materialRef;   //素材
    private Specs specsRef;      //规格
    private Integer index;     //堆叠顺序

    private Layer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Material getMaterialRef() {
        return materialRef;
    }

    public void setMaterialRef(Material materialRef) {
        this.materialRef = materialRef;
    }

    public Specs getSpecsRef() {
        return specsRef;
    }

    public void setSpecsRef(Specs specsRef) {
        this.specsRef = specsRef;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
