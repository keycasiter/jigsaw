package com.guanjian.jigsaw.bean.material;

/**
 * 图片素材
 *
 * @author guanjian
 * @description
 * @date 2019/6/14 9:17
 */
public class Photo {
    private String id;       //id
    private String url;      //图片文件网络链接
    private String path;     //图片文件路径

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static boolean isInstance(Object o) {
        return o instanceof Photo;
    }
}
