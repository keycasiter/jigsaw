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
     * 画板
     */
    private PanelBean panel;
    /**
     * 图层
     */
    private List<LayerBean> layerList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PanelBean getPanel() {
        return panel;
    }

    public void setPanel(PanelBean panel) {
        this.panel = panel;
    }

    public List<LayerBean> getLayerList() {
        return layerList;
    }

    public void setLayerList(List<LayerBean> layerList) {
        this.layerList = layerList;
    }
}
