package com.guanjian.jigsaw.domain.specs;

/**
 * @author guanjian
 * @description
 * @date 2019/6/14 10:39
 */
public class Element implements Specs {
    private Integer height;//长度
    private Integer width;//宽度
    private Integer x;  //x轴
    private Integer y;  //y轴

    private Element() {
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public static class Builder {
        private Element e;

        public Builder() {
            e = new Element();
        }

        public Builder height(int height) {
            e.height = height;
            return this;
        }

        public Builder width(int width) {
            e.width = width;
            return this;
        }

        public Builder x(int x) {
            e.x = x;
            return this;
        }

        public Builder y(int y) {
            e.y = y;
            return this;
        }

        public Element build() {
            return e;
        }
    }
}
