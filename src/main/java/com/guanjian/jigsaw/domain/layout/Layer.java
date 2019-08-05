package com.guanjian.jigsaw.domain.layout;

import com.guanjian.jigsaw.domain.material.Material;
import com.guanjian.jigsaw.domain.specs.Specs;

/**
 * 图层
 *
 * @author guanjian
 * @description
 * @date 2019/6/12 20:14
 */
public class Layer {
    private Material material;//素材
    private Specs specs;      //规格

    public Layer(Material material, Specs specs) {
        this.material = material;
        this.specs = specs;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Specs getSpecs() {
        return specs;
    }

    public void setSpecs(Specs specs) {
        this.specs = specs;
    }
}
