package com.abc.cutout.baiduseg;

import com.abc.utils.BaiDuUtils.Base64Util;
import com.abc.utils.BaiDuUtils.FileUtil;
import com.abc.utils.BaiDuUtils.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.net.URLEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

	public static BufferedImage resize(BufferedImage img, int newW, int newH) {
		Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
		BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = dimg.createGraphics();
		g2d.drawImage(tmp, 0, 0, null);
		g2d.dispose();

		return dimg;
	}

	public static void convert(String labelmapBase64) {
		try {
			byte[] bytes = Base64.getDecoder().decode(labelmapBase64);
			InputStream is = new ByteArrayInputStream(bytes);
			BufferedImage image = ImageIO.read(is);
			BufferedImage newImage = resize(image, image.getWidth(), image.getHeight());
			BufferedImage grayImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_BYTE_GRAY);
			for (int i = 0; i < image.getWidth(); i++) {
				for (int j = 0; j < image.getHeight(); j++) {
					int rgb = newImage.getRGB(i, j);
					grayImage.setRGB(i, j, rgb * 255); // 将像素存入缓冲区
				}
			}
			File newFile = new File("/Users/zishang/Downloads/baidu42.jpg");
			ImageIO.write(grayImage, "jpg", newFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String body_seg = BodySeg.body_seg("/Users/zishang/Downloads/5.jpeg");
		JSONObject jsonObject = JSON.parseObject(body_seg);
		String labelmap = jsonObject.getString("labelmap");
		String scoremap = jsonObject.getString("scoremap");
		String foreground = jsonObject.getString("foreground");

		convert(foreground);

	}
}
