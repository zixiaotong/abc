package com.abc.cutout.ali;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Base64;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.HashMap;
import java.util.List;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class MattingAPI {

    // 以下两个值可在阿里API网关中，对应的应用中找到
    private final String AppKey = "203802112";
    private final String AppSecret = "8o4j72n091tn2j180tvzi9yi9nj7ra48";

    private final String Stage = "RELEASE"; // "RELEASE" or "TEST"

    // 证件照制作接口
    private final String IDPhotoAPIServer = "https://alidphoto.aisegment.com";
    private final String IDPhotoAPIUri = "/idphoto/make";

    // 人像分割接口
    private final String ImageSegAPIServer = "https://aliapi.aisegment.com";
    private final String SegMattingAPIUri = "/segment/matting";

    // 头像分割接口
    private final String PersonSegAPIServer = "https://person.market.alicloudapi.com";
    private final String PersonHeadSegAPIUri = "segment/person/head";

    // 商品裁剪接口
    private final String CommodityCropServer = "https://ecimage.market.alicloudapi.com";
    private final String CommodityCropAPIUri = "/commodity/crop";

    private final int MaxPhotoEdge = 1500;

    private String byteArrayToHexString(byte[] b) {
        StringBuilder hex = new StringBuilder();
        String code;
        for (int n = 0; b != null && n < b.length; n++) {
            code = Integer.toHexString(b[n] & 0XFF);
            if (code.length() == 1) {
                hex.append('0');
            }
            hex.append(code);
        }
        return hex.toString().toLowerCase();
    }

    private byte[] sha256HMAC(String message, String secret) throws Exception {

        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        return sha256_HMAC.doFinal(message.getBytes());

    }

    private byte[] md5Hash(String dataStr) throws Exception {

        dataStr = dataStr;
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(dataStr.getBytes("UTF8"));
        byte bytes[] = md5.digest();
        return bytes;
    }

    private String base64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public byte[] resizeAndReadImage(File srcFile) throws IOException {
        ByteArrayOutputStream out = null;
        try {
            // 构造Image对象
            BufferedImage src = ImageIO.read(srcFile);
            int width = src.getWidth();
            int height = src.getHeight();

            int maxEdge = Math.max(width, height);

            // 接口要求图片最长边不超过1500个像素，超过的话，需要先做缩放
            if (maxEdge <= this.MaxPhotoEdge) {
                FileInputStream inputFile = new FileInputStream(srcFile);
                byte[] buffer = new byte[(int) srcFile.length()];
                inputFile.read(buffer);
                inputFile.close();
                return buffer;
            }
            float ratio = (float) this.MaxPhotoEdge / (float) maxEdge;
            int newWidth = (int) ((float) width * ratio);
            int newHeight = (int) ((float) height * ratio);

            BufferedImage tag = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
            tag.getGraphics().drawImage(src, 0, 0, newWidth, newHeight, null);

            out = new ByteArrayOutputStream();
            ImageIO.write(tag, "JPEG", out);
            return out.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return null;
    }


    private String httpPost(String httpUrl, Map<String, String> headers, String postData) {

        HttpURLConnection connection = null;
        InputStream is = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;
        try {
            URL url = new URL(httpUrl);
            trustAllHosts();
            connection = (HttpURLConnection) url.openConnection();
            if (url.getProtocol().toLowerCase().equals("https")) {
                HttpsURLConnection https = (HttpsURLConnection) connection;
                https.setHostnameVerifier(DO_NOT_VERIFY);
                //con = https;
            }

            connection.setRequestMethod("POST");
            connection.setConnectTimeout(15000);
            connection.setReadTimeout(60000);

            connection.setDoOutput(true);

            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    connection.setRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            os = connection.getOutputStream();
            os.write(postData.getBytes());

            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp);
                    sbf.append("\r\n");
                }
                result = sbf.toString();

            } else {
                System.out.println("bad status code:" + connection.getResponseCode());
                Map<String, List<String>> map = connection.getHeaderFields();
                for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                    System.out.println("Key : " + entry.getKey() +
                            " ,Value : " + entry.getValue());
                }
                is = connection.getErrorStream();
                if (is != null) {
                    br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

                    StringBuffer sbf = new StringBuffer();
                    String temp = null;
                    while ((temp = br.readLine()) != null) {
                        sbf.append(temp);
                        sbf.append("\r\n");
                    }
                    result = sbf.toString();
                }

            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            // 断开与远程地址url的连接
            connection.disconnect();
        }
        return result;
    }

    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static void downloadFromUrl(String urlStr, String fileName) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setConnectTimeout(10 * 1000);
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        InputStream inputStream = conn.getInputStream();
        //获取自己数组
        byte[] getData = readInputStream(inputStream);

        File file = new File(fileName);
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(getData);
        if (fos != null) {
            fos.close();
        }
        if (inputStream != null) {
            inputStream.close();
        }


        System.out.println("info:" + url + " download success");

    }

    final static HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier() {

        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };

    /**
     * Trust every server - dont check for any certificate
     */
    private static void trustAllHosts() {
        final String TAG = "trustAllHosts";
        // Create a trust manager that does not validate certificate chains
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {

            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return new java.security.cert.X509Certificate[]{};
            }

            public void checkClientTrusted(X509Certificate[] chain, String authType) /*throws CertificateException*/ {
//                Log.i(TAG, "checkClientTrusted");
            }

            public void checkServerTrusted(X509Certificate[] chain, String authType) /*throws CertificateException*/ {
//                Log.i(TAG, "checkServerTrusted");
            }
        }};

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String extractValueFromJsonString(String jsonString, String key) {
        String regex = "\"" + key + "\":([^(,|\\}|\\])]*)";
        Matcher matcher = Pattern.compile(regex).matcher(jsonString);
        while (matcher.find()) {
            String val = matcher.group(1);
            val = val.trim();
            if (val.startsWith("\"")) {
                val = val.substring(1);
            }
            if (val.endsWith("\"")) {
                val = val.substring(0, val.length() - 1);
            }
            return val;
        }
        return null;

    }

    private String apiCall(String apiServer, String apiUri, String imageFileName, Map<String, String> args) {
        try {

            File file = new File(imageFileName);
            //FileInputStream inputFile = new FileInputStream(file);
            //byte[] buffer = new byte[(int)file.length()];
            //inputFile.read(buffer);
            //inputFile.close();
            byte[] buffer = resizeAndReadImage(file);
            if (buffer == null) {
                return null;
            }
            // BASE64Encoder b64Encoder = new BASE64Encoder();
            String imageBase64 = base64(buffer);
            String fileName = file.getName();
            String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1);
            String photoType = fileExt.replace(".", "");

            String body = "";
            if (args != null) {
                for (Map.Entry<String, String> entry : args.entrySet()) {
                    if (body.length() > 0) {
                        body += ",";
                    }
                    body += String.format("\"%s\":\"%s\"",
                            entry.getKey(),
                            entry.getValue());
                }
            }
            if (body.length() > 0) {
                body += ",";
            }
            body = "{" + body + "\"photo\":\"" + imageBase64 + "\"," +
                    "\"type\":\"" + photoType + "\"}";

            String bodyMd5 = base64(md5Hash(body));

            String method = "POST";
            String accept = "application/json";
            String contentType = "application/octet-stream; charset=utf-8";
            String dateStr = "";
            String signHeaders = "";

            String stringToSign = method + '\n'
                    + accept + '\n'
                    + bodyMd5 + '\n'
                    + contentType + '\n'
                    + dateStr + '\n'
                    + signHeaders
                    + apiUri;

            String signed = base64(sha256HMAC(stringToSign, this.AppSecret));

            Map<String, String> headers = new HashMap<String, String>();
            headers.put("Accept", accept);
            headers.put("Content-MD5", bodyMd5);
            headers.put("Content-Type", contentType);
            headers.put("X-Ca-Key", this.AppKey);
            headers.put("X-Ca-Signature", signed);
            headers.put("X-Ca-Stage", this.Stage);

            String result = httpPost(apiServer + apiUri, headers, body);
            if (result == null) {
                System.out.println("httpPost call fail");
                return null;
            }

            System.out.println("result:" + result);
            return result;


        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            e.printStackTrace();
        }

        return null;
    }

    // 证件照制作接口
    public Boolean idPhotoMake(String imageFileName, String specID, String bkColor, String saveFilePath) {

        try {
            Map<String, String> args = new HashMap<String, String>();
            args.put("spec", specID);
            if (bkColor != null && bkColor != "") {
                args.put("bk", bkColor);
            }

            String result = apiCall(this.IDPhotoAPIServer,
                    this.IDPhotoAPIUri,
                    imageFileName,
                    args);
            if (result == null) {
                return false;
            }

            // 正确做法是使用json解析库，
            // 这里为了减少依赖，直接使用正则表达式解析
            String status = extractValueFromJsonString(result, "status");
            if (!status.equals("0")) {
                System.out.println("bad status:" + status);
                return false;
            }
            String url = extractValueFromJsonString(result, "result");
            if (url != null) {
                downloadFromUrl(url, saveFilePath);
            }

            return true;
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // 人像分割接口
    public Boolean imageSeg(String imageFileName) {

        try {
            /* 可选参数：
    		    face_required: 整形，设置人像分割前是否检测必须有人脸存在，
    		                   0为检测，1为不检测，默认为0，
    		                   设置这个参数后，可能导致人体背影无法抠图
    		*/
            String result = apiCall(this.ImageSegAPIServer,
                    this.SegMattingAPIUri,
                    imageFileName,
                    null);
            if (result == null) {
                return false;
            }

            // 正确做法是使用json解析库，
            // 这里为了减少依赖，直接使用正则表达式解析
            String status = extractValueFromJsonString(result, "status");
            if (!status.equals("0")) {
                System.out.println("bad status:" + status);
                return false;
            }
            String url = extractValueFromJsonString(result, "result");

            System.out.println("result url: " + url);
            System.out.println("如果您期望得到alpha通道图，可以使用接口（https://aliapi.aisegment.com/segment/alpha）");
            return true;
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // 头像分割接口
    public Boolean headSeg(String imageFileName) {

        try {
    		/* 可选参数：
    		     border_ratio: 浮点，仅带白边接口可用，在头像边缘增加白边（或者其他颜色）宽度，取值为0-0.5，
                               这个宽度是相对于图片宽度和高度最大值的比例，
                               比如原图尺寸为640x480，border_ratio为0.2，
                               则添加的白边的宽度为：max(640,480) * 0.2 = 96个像素
                 margin_color: 字符串颜色值(如"#ff0000")仅带白边接口可用， 在头像边缘增加边框的颜色，默认为白色
            */
            String result = apiCall(this.PersonSegAPIServer,
                    this.PersonHeadSegAPIUri,
                    imageFileName,
                    null);
            if (result == null) {
                return false;
            }

            // 正确做法是使用json解析库，
            // 这里为了减少依赖，直接使用正则表达式解析
            String status = extractValueFromJsonString(result, "status");
            if (!status.equals("0")) {
                System.out.println("bad status:" + status);
                return false;
            }
            String url = extractValueFromJsonString(result, "result");

            System.out.println("result url: " + url);
            System.out.println("result是alpha通道图，还需要通过和原图进行合并才能得到png透明背景图，合并参考我们另外一段代码）");
            return true;
        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    // 商品裁剪制作接口
//    public Boolean commodityCrop(String imageFileName, int[] outputSize, float objectRatio, String saveFilePath) {
//
//        try {
//            Map<String, String> args = new HashMap<String, String>();
//            args.put("output_size", outputSize);
//            args.put("object_ratio", objectRatio);
//
//            String result = apiCall(this.CommodityCropServer,
//                    this.CommodityCropServerAPIUri,
//                    imageFileName,
//                    args);
//            if (result == null) {
//                return false;
//            }
//
//            // 正确做法是使用json解析库，
//            // 这里为了减少依赖，直接使用正则表达式解析
//            String status = extractValueFromJsonString(result, "status");
//            if (!status.equals("0")) {
//                System.out.println("bad status:" + status);
//                return false;
//            }
//            String url = extractValueFromJsonString(result, "result");
//            if (url != null) {
//                downloadFromUrl(url, saveFilePath);
//            }
//
//            return true;
//        } catch (Exception e) {
//            System.out.println("Exception:" + e.getMessage());
//            e.printStackTrace();
//        }
//        return false;
//    }

    public static void main(String[] args) {
        MattingAPI api = new MattingAPI();

        // 人像分割接口函数调用
        // api.imageSeg("/Users/shanglei/Downloads/1.jpeg");

        // 头像分割接口函数调用
         api.headSeg("/Users/shanglei/Downloads/1.jpeg");

        // 证件照制作接口函数调用
//        api.idPhotoMake("/Users/ken/Desktop/xx.png", // 原图
//                "1", // 规格ID，可以通过使用文档找到期望的ID
//                null, // 背景颜色
//                "/Users/ken/Desktop/2.jpg" // 证件照结果图
//        );


        /*
        // 商品裁剪接口函数调用
        api.commodityCrop("/Users/ken/Desktop/xx.png", // 原图
                          new int[]{600, 800}, // 输出图大小
                          0.9,                 // 输出结果图中，期望的商品占比
                          "/Users/ken/Desktop/2.jpg" // 结果图
                          );
       */
        return;
    }

}
