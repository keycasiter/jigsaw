package com.guanjian.jigsaw.constant;

import com.guanjian.jigsaw.util.FontUtil;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author guanjian
 * @description
 * @date 2019/6/14 13:52
 */
public final class Constants {
    //画板默认宽度
    public final static int DEFAULT_PANEL_WIDTH = 500;
    //画板默认高度
    public final static int DEFAULT_PANEL_HEIGHT = 1000;

    //X轴起点坐标
    public final static int X_START = 0;
    //Y轴起点坐标
    public final static int Y_START = 0;

    //外部字体文件存放路径
    public final static String FONT_FILE_PATH = FontUtil.class.getResource("/").getPath().concat("font");
    //临时文件存放路径
    public final static String TMP_FILE_PATH = FontUtil.class.getResource("/").getPath();

    //全局临时文件线程绑定池
    public final static ThreadLocal<List<String>> TMP_FILE_POOL = new ThreadLocal<List<String>>() {
        @Override
        protected List<String> initialValue() {
            return new CopyOnWriteArrayList<String>();
        }
    };
}
