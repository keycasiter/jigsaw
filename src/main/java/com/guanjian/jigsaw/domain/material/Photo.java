package com.guanjian.jigsaw.domain.material;

/**
 * 图片素材
 *
 * @author guanjian
 * @description
 * @date 2019/6/14 9:17
 */
public class Photo implements Material {
    private String imgUrl;      //图片文件网络链接
    private String imgPath;     //图片文件路径

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public static boolean isInstance(Object o) {
        return o instanceof Photo;
    }
}
