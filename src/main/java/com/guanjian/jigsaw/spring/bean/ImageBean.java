package com.guanjian.jigsaw.spring.bean;

import java.io.Serializable;

/**
 * 图片素材
 *
 * @author guanjian
 * @description
 * @date 2019/6/14 9:17
 */
public class ImageBean implements Material, Serializable {

    private static final long serialVersionUID = 7027243541313225418L;

    private String id;       //id
    private String path;     //图片文件路径

    public ImageBean() {
    }

    public ImageBean(String id, String path) {
        this.id = id;
        this.path = path;
    }

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
