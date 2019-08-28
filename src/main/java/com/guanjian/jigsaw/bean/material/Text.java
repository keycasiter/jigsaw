package com.guanjian.jigsaw.bean.material;

/**
 * 文字素材
 *
 * @author guanjian
 * @description
 * @date 2019/6/14 9:10
 */
public class Text implements Material{
    private String id;              //id
    private String rgbColor;        //RGB颜色
    private String fontText;           //字体文本
    private Integer fontSize;           //字体大小
    private String fontFormat;         //字体样式

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

    public static boolean isInstance(Object o) {
        return o instanceof Text;
    }

}
