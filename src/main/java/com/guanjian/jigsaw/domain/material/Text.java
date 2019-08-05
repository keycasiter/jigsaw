package com.guanjian.jigsaw.domain.material;

import java.awt.*;
import java.text.AttributedString;

/**
 * 文字素材
 *
 * @author guanjian
 * @description
 * @date 2019/6/14 9:10
 */
public class Text implements Material {
    private Color color;        //颜色
    private AttributedString attributedString;//文本属性


    private Text() {
    }

    public Color getColor() {
        return color;
    }

    public AttributedString getAttributedString() {
        return attributedString;
    }

    public static boolean isInstance(Object o) {
        return o instanceof Text;
    }

    public static class Builder {
        private Text text;

        public Builder() {
            text = new Text();
        }

        public Builder color(Color color) {
            text.color = color;
            return this;
        }

        public Builder attributedString(AttributedString attributedString) {
            text.attributedString = attributedString;
            return this;
        }

        public Text build() {
            return text;
        }
    }
}
