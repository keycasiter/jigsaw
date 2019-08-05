package com.guanjian.jigsaw.service;

import com.guanjian.jigsaw.domain.layout.Layer;

import java.util.List;

/**
 * @author guanjian
 * @description
 * @date 2019/7/26 9:28
 */
public abstract class AbstractGrapicsFactory implements IGraphicsFactory {

    public abstract void produce(List<Layer> layers);
}
