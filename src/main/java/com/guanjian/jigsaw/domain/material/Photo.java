package com.guanjian.jigsaw.domain.material;

import com.guanjian.jigsaw.util.ImageUtil;

import java.io.File;

/**
 * 图片素材
 *
 * @author guanjian
 * @description
 * @date 2019/6/14 9:17
 */
public class Photo implements Material {
    private File imgFile;      //图片文件

    public Photo(File imgFile) {
        this.imgFile = imgFile;
    }

    public File getImgFile() {
        return imgFile;
    }

    public void setImgFile(File imgFile) {
        this.imgFile = imgFile;
    }

    public static boolean isInstance(Object o) {
        return o instanceof Photo;
    }
}
