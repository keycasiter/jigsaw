package com.guanjian.jigsaw.test;

import com.guanjian.jigsaw.spring.bean.LayerBean;
import com.guanjian.jigsaw.service.GraphicsFactory;

import java.util.ArrayList;
import java.util.List;

public class ModelTest {

    public static void main(String[] args) {
        GraphicsFactory.Builder gfBuilder = new GraphicsFactory.Builder(690, 930);
        GraphicsFactory gf = gfBuilder.build();

        List<LayerBean> layerBeanList = new ArrayList<LayerBean>();

        long start = System.currentTimeMillis();
        gf.produce(layerBeanList);
        long end = System.currentTimeMillis();
        System.out.println(String.format("消耗时间 %s ms", end - start));
    }

}