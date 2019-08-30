package com.guanjian.jigsaw.spring.bean;

import java.io.Serializable;

/**
 * 图片
 *
 * @author guanjian
 * @description
 * @date 2019/6/14 9:17
 */
public class ImageBean implements Serializable {

    private static final long serialVersionUID = 7027243541313225418L;

    /**
     * id标识
     */
    private String id;
    /**
     * 图片路径
     */
    private String path;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
