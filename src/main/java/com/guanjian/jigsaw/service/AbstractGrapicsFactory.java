package com.guanjian.jigsaw.service;

import com.guanjian.jigsaw.spring.bean.LayerBean;

import java.util.List;

/**
 * @author guanjian
 * @description
 * @date 2019/7/26 9:28
 */
public abstract class AbstractGrapicsFactory implements IGraphicsFactory {

    /**
     * 图片制作方法
     *
     * @param layerBeans 图层素材
     */
    public abstract void produce(List<LayerBean> layerBeans);
}
