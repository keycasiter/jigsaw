package com.guanjian.jigsaw.spring.bean;

import java.io.Serializable;

/**
 * @author guanjian
 * @description
 * @date 2019/6/14 9:10
 */
public class TextBean implements Serializable {

    private static final long serialVersionUID = 4440001171404980039L;

    /**
     * id标识
     */
    private String id;
    /**
     * RGB颜色
     */
    private String rgbColor;
    /**
     * 字体文本
     */
    private String text;
    /**
     * 字体大小
     */
    private Integer size;
    /**
     * 字体样式
     */
    private String format;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRgbColor() {
        return rgbColor;
    }

    public void setRgbColor(String rgbColor) {
        this.rgbColor = rgbColor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
