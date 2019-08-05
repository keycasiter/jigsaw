package com.guanjian.jigsaw.service;

import com.guanjian.jigsaw.domain.layout.Layer;

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
     * @param layers 图层素材
     */
    void produce(List<Layer> layers);
}
