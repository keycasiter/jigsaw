package com.guanjian.jigsaw.service;

import com.guanjian.jigsaw.constant.Constants;
import com.guanjian.jigsaw.spring.bean.ImageBean;
import com.guanjian.jigsaw.spring.bean.LayerBean;
import com.guanjian.jigsaw.spring.bean.TextBean;
import com.guanjian.jigsaw.util.ImageUtil;
import com.guanjian.jigsaw.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author guanjian
 * @description
 * @date 2019/6/13 11:39
 */
public class GraphicsFactory implements IGraphicsFactory {
    private final static Logger LOGGER = LoggerFactory.getLogger(GraphicsFactory.class);

    /**
     * 画板
     */
    private BufferedImage panel;
    /**
     * 画笔
     */
    private Graphics2D painting;

    /**
     * applicationContext
     */
    private static ApplicationContext applicationContext = SpringUtil.context;

    /**
     * graphicsFactory
     *
     * @description 单例
     */
    private static GraphicsFactory graphicsFactory = new GraphicsFactory();

    private GraphicsFactory() {
    }

    public static GraphicsFactory getInstance() {
        return graphicsFactory;
    }

    /**
     * 绘图方法
     *
     * @param layerBeans 图层素材
     */
    @Override
    public void produce(List<LayerBean> layerBeans) {
        try {
            //1、生成画板
            initPanel();
            //2、描绘图层
            draw(layerBeans);
            //3、生成图像
            print();
        } finally {
            painting.dispose();
            //清理临时文件
            ImageUtil.cleanTmpFile();
        }
    }

    /**
     * 初始化画板
     */
    private void initPanel() {
        final Integer panelWidth = Constants.DEFAULT_PANEL_WIDTH;
        final Integer panelHeight = Constants.DEFAULT_PANEL_HEIGHT;

        final BufferedImage bi = new BufferedImage(panelWidth, panelHeight, BufferedImage.TYPE_INT_RGB);//INT精确度达到一定,RGB三原色
        panel = bi;
        Graphics2D graphics = bi.createGraphics();
        // 设置"抗锯齿"的属性
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics.setColor(Color.WHITE);//设置白色背景
        graphics.fillRect(Constants.X_START, Constants.Y_START, panelWidth, panelHeight);//填充整个屏幕
        painting = bi.createGraphics();
    }

    /**
     * 绘图方法
     *
     * @param layerBeans 图层
     */
    private void draw(List<LayerBean> layerBeans) {
        for (final LayerBean layerBean : layerBeans) {
            execute(layerBean);
        }
    }

    /**
     * 生成图像到本地
     *
     * @return
     */
    private void print() {
        final String filePath = Constants.TMP_FILE_PATH.concat(String.valueOf(System.currentTimeMillis())).concat(".jpg");
        final File file = new File(filePath);
        try {
            ImageIO.write(panel, "JPEG", file);
        } catch (Exception e) {
            LOGGER.error("[jigsaw] print image error", e);
        }

    }

    /**
     * 图像处理
     *
     * @param layerBean
     */
    private void execute(LayerBean layerBean) {
        LayerBean targetLayerBean = layerBean;
        //TODO 根据beanId处理
        if (applicationContext.containsBean(layerBean.getId())) {
            targetLayerBean = (LayerBean) applicationContext.getBean(layerBean.getId());
        }

        final Object material = targetLayerBean.getMaterial();
        //图片图层
        if (material instanceof ImageBean) {
            ImageBean imageBean = (ImageBean) material;

            try {
                final File srcFile = new File(imageBean.getPath());
                final Image image = ImageIO.read(srcFile);
                BufferedImage bi = null;
                if (srcFile.getName().endsWith(".png")) {
                    bi = new BufferedImage(targetLayerBean.getWidth(), targetLayerBean.getHeight(), BufferedImage.TYPE_INT_ARGB);
                } else {
                    bi = new BufferedImage(targetLayerBean.getWidth(), targetLayerBean.getHeight(), BufferedImage.TYPE_INT_RGB);
                }
                painting.drawImage(image.getScaledInstance(bi.getWidth(), bi.getHeight(), Image.SCALE_SMOOTH), targetLayerBean.getCoordinateX(), targetLayerBean.getCoordinateY(), bi.getWidth(), bi.getHeight(), null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //文字图层
        if (material instanceof TextBean) {
            TextBean textBean = (TextBean) material;
            //修正字体坐标
            final int fontSize = textBean.getSize();
            String[] rgbColor = textBean.getRgbColor().split(Pattern.quote(Constants.Global.COMMA));
            painting.setColor(new Color(Integer.valueOf(rgbColor[0]), Integer.valueOf(rgbColor[1]), Integer.valueOf(rgbColor[2])));
            painting.drawString(textBean.getText(), targetLayerBean.getCoordinateX(), targetLayerBean.getCoordinateY() + fontSize);
        }
    }
}
