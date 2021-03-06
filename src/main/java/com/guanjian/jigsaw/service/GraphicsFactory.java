package com.guanjian.jigsaw.service;

import com.guanjian.jigsaw.constant.Constants;
import com.guanjian.jigsaw.domain.layout.Layer;
import com.guanjian.jigsaw.domain.material.Material;
import com.guanjian.jigsaw.domain.material.Photo;
import com.guanjian.jigsaw.domain.material.Text;
import com.guanjian.jigsaw.domain.specs.Element;
import com.guanjian.jigsaw.domain.specs.Specs;
import com.guanjian.jigsaw.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author guanjian
 * @description
 * @date 2019/6/13 11:39
 */
public class GraphicsFactory extends AbstractGrapicsFactory {
    private final static Logger LOGGER = LoggerFactory.getLogger(GraphicsFactory.class);

    private BufferedImage panel; //画板
    private Graphics2D painting; //画笔

    private Integer width;  //画板宽度
    private Integer height; //画板高度

    private GraphicsFactory() {
    }

    @Override
    public void produce(List<Layer> layers) {
        try {
            //1、创建画板
            buildPanel();
            //2、描绘图层
            draw(layers);
            //3、生成图像
            print();
        } finally {
            painting.dispose();
            //清理临时文件
            ImageUtil.cleanTmpFile();
        }
    }

    public static class Builder {
        private GraphicsFactory gf;

        public Builder(int width, int height) {
            gf = new GraphicsFactory();
            gf.width = width;
            gf.height = height;
        }

        public GraphicsFactory build() {
            return gf;
        }

    }

    /**
     * 创建画板
     */
    private void buildPanel() {
        final Integer panelWidth = null == this.width ? Constants.DEFAULT_PANEL_WIDTH : this.width;
        final Integer panelHeight = null == this.height ? Constants.DEFAULT_PANEL_HEIGHT : this.height;
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
     * @param layers 图层
     */
    private void draw(List<Layer> layers) {
        for (final Layer layer : layers) {
            final Material material = layer.getMaterial();
            final Specs specs = layer.getSpecs();
            execute(material, specs);
        }
    }

    /**
     * 生成图像并上传图片到云端
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
        } finally {
            if (file.exists()) {
                file.delete();
            }
        }

    }

    /**
     * 图像处理
     *
     * @param material
     * @param specs
     */
    private void execute(Material material, Specs specs) {
        //图片图层
        if (Photo.isInstance(material)) {
            Photo photo = (Photo) material;
            Element element = (Element) specs;

            try {
                final File srcFile = photo.getImgFile();
                final Image image = ImageIO.read(srcFile);
                BufferedImage bi = null;
                if (srcFile.getName().endsWith(".png")) {
                    bi = new BufferedImage(element.getWidth(), element.getHeight(), BufferedImage.TYPE_INT_ARGB);
                } else {
                    bi = new BufferedImage(element.getWidth(), element.getHeight(), BufferedImage.TYPE_INT_RGB);
                }
                painting.drawImage(image.getScaledInstance(bi.getWidth(), bi.getHeight(), Image.SCALE_SMOOTH), element.getX(), element.getY(), bi.getWidth(), bi.getHeight(), null);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //文字图层
        if (Text.isInstance(material)) {
            Text text = (Text) material;
            Element element = (Element) specs;
            //修正字体坐标
            final int fontSize = ((Font) text.getAttributedString().getIterator().getAttribute(TextAttribute.FONT)).getSize();
            painting.setColor(text.getColor());
            painting.drawString(text.getAttributedString().getIterator(), element.getX(), element.getY() + fontSize);
        }
    }
}
