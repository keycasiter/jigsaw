package com.guanjian.jigsaw.spring.bean;

import java.io.Serializable;
import java.util.List;

/**
 * created by guanjian on 2019/8/28 13:22
 */
public class LayoutBean implements Serializable {

    private static final long serialVersionUID = 1851454407580244706L;

    private String id;
    private PanelBean panelId;
    private List<LayerBean> layerIdList;

    public LayoutBean() {
    }

    public LayoutBean(String id, com.guanjian.jigsaw.spring.bean.PanelBean panelId, List<com.guanjian.jigsaw.spring.bean.LayerBean> layerIdList) {
        this.id = id;
        this.panelId = panelId;
        this.layerIdList = layerIdList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public PanelBean getPanelId() {
        return panelId;
    }

    public void setPanelId(PanelBean panelId) {
        this.panelId = panelId;
    }

    public List<LayerBean> getLayerIdList() {
        return layerIdList;
    }

    public void setLayerIdList(List<LayerBean> layerIdList) {
        this.layerIdList = layerIdList;
    }
}
