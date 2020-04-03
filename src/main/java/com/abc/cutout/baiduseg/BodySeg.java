package com.abc.cutout.baiduseg;

import com.abc.utils.BaiDuUtils.Base64Util;
import com.abc.utils.BaiDuUtils.FileUtil;
import com.abc.utils.BaiDuUtils.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.URLEncoder;

import java.io.*;
import java.util.Base64;

public class BodySeg {
    /**
     * 重要提示代码中所需工具类 FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3 下载
     */

    // API Key TzQg8tnfHsRIpT0jnFdIQPjS
    // Secret Key ItHn3IrakjCb3GBRz44iC4jnQ5ZAqyEj
    // AppID 19228345
    public static String body_seg(String filePath) {
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/image-classify/v1/body_seg";
        try {
            byte[] imgData = FileUtil.readFileByBytes(filePath);
            String imgStr = Base64Util.encode(imgData);
            String imgParam = URLEncoder.encode(imgStr, "UTF-8");
            String param = "image=" + imgParam;
            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
            String accessToken = "24.53c75fb8aaae8a9739b72d0b18744f22.2592000.1588429575.282335-19228345";
            String result = HttpUtil.post(url, accessToken, param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * base64字符串转化成图片
     *
     * @param imgStr      接口返回的图片base64数据
     * @param imgFilePath 即将要保存的图片的本地路径包含文件名称和格式 例如:F:/generateimage.jpg
     * @return
     */
    public static boolean GenerateImage(String imgStr, String imgFilePath) { // 对字节数组字符串进行Base64解码并生成图片
        if (imgStr == null) // 图像数据为空
            return false;
        Base64.Decoder decoder = Base64.getDecoder();
        try {
            // Base64解码
            byte[] b = decoder.decode(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) { // 调整异常数据
                    b[i] += 256;
                }
            }
            // 生成jpeg图片
            OutputStream out = new FileOutputStream(imgFilePath); // 新生成的图片
            out.write(b);
            out.flush();
            out.close();
            System.out.println("保存成功" + imgFilePath);
            return true;
        } catch (Exception e) {
            System.out.println("出错了" + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        String body_seg = body_seg("/Users/shanglei/Downloads/code/idea/stone/abc/src/main/java/com/abc/cutout/1.jpeg");
        JSONObject jsonObject = JSON.parseObject(body_seg);
        String foreground = jsonObject.getString("foreground");
        //把foreground 保存成png格式的透明图片
        GenerateImage(foreground, "/Users/shanglei/Downloads/101105.png");
    }
}
