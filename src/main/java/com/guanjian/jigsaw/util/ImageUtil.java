package com.guanjian.jigsaw.util;

import com.guanjian.jigsaw.constant.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * @author guanjian
 * @description
 * @date 2019/7/25 20:43
 */
public class ImageUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(ImageUtil.class);

    /**
     * 网络url图片转文件
     *
     * @param url
     * @return
     */
    public static File urlToFile(String url) {
        //1、url抓取图像
        InputStream inputStream = fetchImageFromUrl(url);
        //2、转换成通用字节流
        byte[] bytes = readInputStream(inputStream);
        //3、字节流转文件
        return byteToFile(bytes, String.valueOf(url.hashCode()).concat(".jpg"));
    }

    //清除临时文件方法
    public static void cleanTmpFile() {
        //取出线程绑定临时文件路径
        final List<String> fileList = Constants.TMP_FILE_POOL.get();
        if (CollectionUtils.isEmpty(fileList)) return;
        //清理临时文件
        for (String filePath : fileList) {
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }
        }
        //清除线程容器绑定的临时文件路径
        Constants.TMP_FILE_POOL.get().clear();
    }

    /**
     * 根据URL抓取文件
     *
     * @param descUrl
     * @return
     */
    private static InputStream fetchImageFromUrl(String descUrl) {
        try {
            //new一个URL对象
            URL url = new URL(descUrl);
            //打开链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置请求方式为"GET"
            conn.setRequestMethod("GET");
            //超时响应时间为5秒
            conn.setConnectTimeout(2 * 1000);
            //通过输入流获取图片数据
            return conn.getInputStream();
        } catch (Exception e) {
            LOGGER.error("[jigsaw] fetch img from url error", e);
            return null;
        }
    }

    /**
     * 得到图片的二进制数据，以二进制封装得到数据，具有通用性
     *
     * @param inStream
     * @return
     * @throws Exception
     */
    private static byte[] readInputStream(InputStream inStream) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        try {
            //创建一个Buffer字符串
            byte[] buffer = new byte[1024];
            //每次读取的字符串长度，如果为-1，代表全部读取完毕
            int len = 0;
            //使用一个输入流从buffer里把数据读取出来
            while ((len = inStream.read(buffer)) != -1) {
                //用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
                outStream.write(buffer, 0, len);
            }
            //关闭输入流
            inStream.close();
        } catch (Exception e) {
            LOGGER.error("[jigsaw] read input stream error", e);
        }
        return outStream.toByteArray();
    }

    /**
     * 二进制数据转文件
     *
     * @param bytes
     * @param fileName
     * @return
     */
    private static File byteToFile(byte[] bytes, String fileName) {
        OutputStream os = null;
        BufferedOutputStream bos = null;
        File file = null;
        try {
            file = new File(Constants.TMP_FILE_PATH.concat(fileName));
            os = new FileOutputStream(file);
            bos = new BufferedOutputStream(os);
            bos.write(bytes);
            os.close();
            bos.close();
            //线程容器绑定临时文件路径
            Constants.TMP_FILE_POOL.get().add(file.getAbsolutePath());
        } catch (Exception e) {
            LOGGER.error("[jigsaw] byte transfer file error", e);
        }
        return file;
    }
}
