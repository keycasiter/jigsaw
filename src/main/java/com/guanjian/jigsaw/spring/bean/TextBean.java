package com.guanjian.jigsaw.spring.bean;

import java.io.Serializable;

/**
 * @author guanjian
 * @description
 * @date 2019/6/14 9:10
 */
public class TextBean implements Material , Serializable {

    private static final long serialVersionUID = 4440001171404980039L;

    private String id;              //id
    private String rgbColor;        //RGB颜色
    private String fontText;           //字体文本
    private Integer fontSize;           //字体大小
    private String fontFormat;         //字体样式

    public TextBean() {}

    public TextBean(String id, String rgbColor, String fontText, Integer fontSize, String fontFormat) {
        this.id = id;
        this.rgbColor = rgbColor;
        this.fontText = fontText;
        this.fontSize = fontSize;
        this.fontFormat = fontFormat;
    }

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

    public String getFontText() {
        return fontText;
    }

    public void setFontText(String fontText) {
        this.fontText = fontText;
    }

    public Integer getFontSize() {
        return fontSize;
    }

    public void setFontSize(Integer fontSize) {
        this.fontSize = fontSize;
    }

    public String getFontFormat() {
        return fontFormat;
    }

    public void setFontFormat(String fontFormat) {
        this.fontFormat = fontFormat;
    }
}
