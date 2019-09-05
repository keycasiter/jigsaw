package com.guanjian.jigsaw.service;

import com.guanjian.jigsaw.spring.bean.LayerBean;

import java.util.List;

/**
 * created by guanjian on 2019/9/4 20:30
 */
public interface IGraphicsFactory {

    public void produce(List<LayerBean> layers);
}
