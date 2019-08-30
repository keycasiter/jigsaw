package com.guanjian.jigsaw.service;

import com.guanjian.jigsaw.spring.bean.LayerBean;

import java.util.List;

/**
 * @author guanjian
 * @description
 * @date 2019/7/26 9:28
 */
public interface IGraphicsFactory {
    /**
     * 拼图方法
     *
     * @param layerBeans 图层素材
     */
    void produce(List<LayerBean> layerBeans);
}
