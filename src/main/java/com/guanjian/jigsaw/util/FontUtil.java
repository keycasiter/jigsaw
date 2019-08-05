package com.guanjian.jigsaw.util;

import com.alibaba.fastjson.JSON;
import com.guanjian.jigsaw.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author guanjian
 * @description
 * @date 2019/7/23 15:00
 */
public class FontUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(FontUtil.class);

    private static Map<String, Font> fontPool = new ConcurrentHashMap<String, Font>();

    private final static String PINGFANG_REGULAR = "pingfang_Regular";
    private final static String PINGFANG_BOLD = "pingfang_Bold";
    private final static String PINGFANG_LIGHT = "pingfang_Light";

    static {
        LOGGER.info("[jigsaw] load font start ......");

        fontPool.put(PINGFANG_REGULAR, loadPingFangRegularFont());
        fontPool.put(PINGFANG_BOLD, loadPingFangBoldFont());
        fontPool.put(PINGFANG_LIGHT, loadPingFangLightFont());

        LOGGER.info("[jigsaw] finished load size:{} , font list :{}", fontPool.size(), JSON.toJSON(fontPool.keySet()));
        LOGGER.info("[jigsaw] load font end ......");
    }

    private static Font loadPingFangLightFont() {
        try {
            File file = new File(Constants.FONT_FILE_PATH.concat(File.separator).concat("PingFangLight.ttf"));
            FileInputStream fis = new FileInputStream(file);
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, fis);
            fis.close();
            return dynamicFont;
        } catch (Exception e) {
            LOGGER.error("load font error", e);
            return getDefaultFont();
        }
    }

    private static Font loadPingFangRegularFont() {
        try {
            File file = new File(Constants.FONT_FILE_PATH.concat(File.separator).concat("PingFangRegular.ttf"));
            FileInputStream fis = new FileInputStream(file);
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, fis);
            fis.close();
            return dynamicFont;
        } catch (Exception e) {
            LOGGER.error("load font error", e);
            return getDefaultFont();
        }
    }

    private static Font loadPingFangBoldFont() {
        try {
            File file = new File(Constants.FONT_FILE_PATH.concat(File.separator).concat("PingFangBold.ttf"));
            FileInputStream fis = new FileInputStream(file);
            Font dynamicFont = Font.createFont(Font.TRUETYPE_FONT, fis);
            fis.close();
            return dynamicFont;
        } catch (Exception e) {
            LOGGER.error("load font error", e);
            return getDefaultFont();
        }
    }

    private static Font getDefaultFont() {
        return new Font("宋体", Font.PLAIN, 16);
    }

    //苹方-常规
    public static Font getPingFangRegular(float size) {
        return fontPool.get(PINGFANG_REGULAR).deriveFont(size);
    }

    //苹方-粗体
    public static Font getPingFangBold(float size) {
        return fontPool.get(PINGFANG_BOLD).deriveFont(size);
    }

    //苹方-细体
    public static Font getPingFangLight(float size) {
        return fontPool.get(PINGFANG_LIGHT).deriveFont(size);
    }

}
