//package com.abc.utils;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.commons.lang.math.NumberUtils;
//import org.apache.commons.lang.math.RandomUtils;
//import org.apache.tomcat.util.codec.binary.Base64;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import javax.servlet.http.HttpServletRequest;
//import java.net.URL;
//import java.net.URLDecoder;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
///**
// * @author xulz
// * @title
// * @date 2015年3月13日下午1:31:50
// */
//public class StringUtil {
//    private static Logger logger = LoggerFactory.getLogger(StringUtil.class);
//
//    private static String[] mobileUserAgents = new String[]{"nokia", "samsung", "windows ce", "iphone", "ipad", "android", "blackberry",
//            "ucweb", "lenovo", "gionee", "htc", "zte", "huawei", "micromessenger"};
//
//    public static Map<String, Integer> SENSITIVE_DOMAIN_MAP = new HashMap<String, Integer>();
//
//    private static Pattern PATTERN_NUM = Pattern.compile("^(\\-|\\+)?\\d+(\\.\\d+)?$");
//
//    private static Pattern PATTERN_A0 = Pattern.compile("^[A-Za-z0-9]+$");//英文、数字
//    private static Pattern PATTERN_0 = Pattern.compile("^[0-9]+$");// 数字
//
//    private static Pattern PATTERN_A1 = Pattern.compile("^[\\u4e00-\\u9fa5A-Za-z0-9_]*$");//中文、英文、数字或下划线
//
//    private static final String KEY = "Z#5ZKK%F$&D1~8E2PFFR14T7";
//
//    /**
//     * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
//     * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
//     *
//     * @param phoneNum
//     * @return
//     */
//    public static boolean isPhoneNum(String phoneNum) {
//        Pattern p = Pattern.compile("^((13[0-9])|(14[0-9])|(17[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");
//        Matcher m = p.matcher(phoneNum);
//        return m.matches();
//    }
//
//    /**
//     * 判断是否是邮箱地址
//     *
//     * @param email
//     * @return
//     */
//    public static boolean isEmail(String email) {
//        Pattern pattern = Pattern.compile("^\\w+([-.]\\w+)*@\\w+([-]\\w+)*\\.(\\w+([-]\\w+)*\\.)*[a-z]{2,3}$");
//        Matcher matcher = pattern.matcher(email);
//        if (matcher.matches()) {
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * 判断字符串长度，英文、字母1，汉字2
//     *
//     * @param str
//     * @return
//     */
//    public static int checkStringLength(String str) {
//        int count = 0;
//        String chinese = "^[\\u4e00-\\u9fa5]$";
//        char[] nameChar = str.toCharArray();
//        for (int i = 0; i < nameChar.length; i++) {
//            Pattern patCn = Pattern.compile(chinese);
//            Matcher matCn = patCn.matcher(nameChar[i] + "");
//            if (matCn.find()) {
//                count = count + 2;
//            } else {
//                count = count + 1;
//            }
//        }
//        return count;
//    }
//
//    public static String getRandomCode(int t) {
//        StringBuffer code = new StringBuffer();
//        for (int i = 0; i < t; i++) {
//            code.append(RandomUtils.nextInt(10));
//        }
//        return code.toString();
//    }
//
//    /**
//     * 对传入的参数进行过滤
//     *
//     * @param request
//     * @param key
//     * @return
//     */
//    public static String convertRequestString(HttpServletRequest request, String key) {
//        String value = null;
//        try {
//            value = WebXssUtil.filterHtmlEncode(request.getParameter(key)).trim();
//        } catch (Exception e) {
//            logger.error("参数过滤异常", e);
//        }
//        return value;
//    }
//
//    /**
//     * 去除html标签
//     *
//     * @param str
//     * @return
//     */
//    public static String removeHtmlTag(String str) {
//        try {
//            // 定义script的正则表达式{或<script[^>]*?>[\\s\\S]*?<\\/script>
//            // String regEx_script =
//            // "<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?script[\\s]*?>";
//            // 定义style的正则表达式{或<style[^>]*?>[\\s\\S]*?<\\/style>
//            // String regEx_style =
//            // "<[\\s]*?style[^>]*?>[\\s\\S]*?<[\\s]*?\\/[\\s]*?style[\\s]*?>";
//            if (StringUtils.isNotBlank(str)) {
//                String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
//                Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
//                Matcher m_html = p_html.matcher(str);
//                str = m_html.replaceAll(""); // 过滤html标签
//            }
//        } catch (Exception e) {
//            logger.error("去除html标签", e);
//        }
//        return str;
//    }
//
//    /**
//     * 去除转义后的html标签
//     *
//     * @param str
//     * @return
//     */
//    public static String removeHtmlTransferTag(String str) {
//        if (StringUtils.isNotBlank(str)) {
//            return str.replaceAll("(\\/|[a-z]|\\&)+;", "");
//        }
//        return null;
//    }
//
//    public static boolean isFromPhone(HttpServletRequest request) {
//        boolean isPhone = false;
//        try {
//            String ua = request.getHeader("user-agent").toLowerCase();
//            if (StringUtils.isNotBlank(ua)) {
//                for (String mobileUserAgent : mobileUserAgents) {
//                    if (ua.indexOf(mobileUserAgent) > -1) {
//                        isPhone = true;
//                        break;
//                    }
//                }
//            }
//        } catch (Exception e) {
//            logger.error("isFromPhone异常", e);
//        }
//        return isPhone;
//    }
//
//    public static int parseInt(String str) {
//        int rtn = 0;
//        try {
//            if (StringUtils.isNotBlank(str)) {
//                Matcher isNum = PATTERN_NUM.matcher(str);
//                if (isNum.matches()) {
//                    rtn = Integer.valueOf(str);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rtn;
//    }
//
//    public static long parseLong(String str) {
//        long rtn = 0;
//        try {
//            if (StringUtils.isNotBlank(str)) {
//                Matcher isNum = PATTERN_NUM.matcher(str);
//                if (isNum.matches()) {
//                    rtn = Long.valueOf(str);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rtn;
//    }
//
//    public static double parseDouble(String str) {
//        double rtn = 0.0;
//        try {
//            if (StringUtils.isNotBlank(str)) {
//                rtn = Double.valueOf(str);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return rtn;
//    }
//
//    public static boolean isJson(String json) {
//        try {
//            JSON.parseObject(json);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    public static boolean isJsonArr(String json) {
//        try {
//            JSON.parseArray(json);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    /**
//     * 校验字符串是否只包含字母和数字
//     *
//     * @param str
//     * @return
//     */
//    public static boolean checkStringA0(String str) {
//        Matcher mat = PATTERN_A0.matcher(str);
//        return mat.find();
//    }
//
//    /**
//     * 截取身份证号，获取出生年
//     *
//     * @param identifyNum
//     * @return
//     */
//    public static int checkUserIdentify(String identifyNum) {
//        if (StringUtils.isNotBlank(identifyNum) && identifyNum.length() > 17) {
//            String age = identifyNum.substring(6, 10);
//            Matcher mat = PATTERN_A0.matcher(age);
//            if (mat.find()) {
//                return Integer.parseInt(age);
//            }
//        }
//        return 0;
//    }
//
//    /**
//     * 处理字符串，过滤掉空格，将中文逗号替换为英文逗号
//     *
//     * @param tag
//     * @return
//     */
//    public static String dealReplaceString(String tag) {
//        if (StringUtils.isNotBlank(tag)) {
//            if (tag.indexOf("，") > -1) {
//                tag = tag.replace("，", ",").replace(" ", "");
//            }
//        }
//        return tag;
//    }
//
//    /**
//     * 获取URL中的域名
//     *
//     * @param uRL
//     * @return
//     */
//    public static String getHostByURL(String uRL) {
//        String host = uRL;
//        try {
//            if (uRL.startsWith("http")) {
//                URL url = new URL(uRL);
//                host = url.getHost();
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return host;
//    }
//
//    /**
//     * 除最后一个字符外其余全替换为*
//     *
//     * @param name
//     * @return
//     */
//    public static String encodeName(String name) {
//        if (StringUtils.isNotBlank(name)) {
//            StringBuffer buffer = new StringBuffer();
//            for (int i = 0; i < name.length(); i++) {
//                if (i < name.length() - 1) {
//                    buffer.append("*");
//                } else {
//                    buffer.append(name.charAt(i));
//                }
//            }
//            return buffer.toString();
//        }
//        return name;
//    }
//
//    public static String decode(String value) {
//        String result = "";
//        try {
//            if (StringUtils.isNotBlank(value)) {
//                result = new String(Base64Coder.decryptBASE64(URLDecoder.decode(value, "UTF-8")));
//                result = DESedeCoder.decode(result, KEY);
//                Pattern pattern = Pattern.compile("\\d+");
//                Matcher matcher = pattern.matcher(result);
//                while (matcher.find()) {
//                    return matcher.group(0);
//                }
//            }
//        } catch (Exception e) {
//            logger.error("加密异常", e);
//        }
//        return result;
//    }
//
//    public static Long getIdFromStr(String courseIdStr) {
//        return NumberUtils.toLong(new String(Base64Coder.decryptBASE64(courseIdStr.replaceFirst("G", ""))));
//    }
//
//    public static String getStrFromId(Long courseId) {
//        return "G" + Base64Coder.encryptBASE64(courseId.toString().getBytes());
//    }
//
//    /**
//     * 将字符数组转换为List
//     *
//     * @param array
//     * @param clazz
//     * @param <T>
//     * @return
//     */
//    public static <T> List<T> stringArrayToList(String[] array, Class<T> clazz) {
//        List<T> obj = null;
//        try {
//            if (array == null || array.length <= 0) {
//                return obj;
//            }
//            if (clazz.equals(Long.class)) {
//                obj = Arrays.stream(array)
//                        .map(s -> clazz.cast(Long.parseLong(s.trim())))
//                        .collect(Collectors.toList());
//            } else if (clazz.equals(Integer.class)) {
//                obj = Arrays.stream(array)
//                        .map(s -> clazz.cast(Integer.parseInt(s.trim())))
//                        .collect(Collectors.toList());
//            }
//        } catch (Exception e) {
//            logger.error("字符串转list类型异常", e);
//        }
//        return obj;
//    }
//
//    public static String hideName(String name) {
//        String result = "";
//        if (StringUtils.isNotBlank(name)) {
//            if (name.length() == 1) {
//                result = name.charAt(0) + "**";
//            } else {
//                result = name.charAt(0) + "**" + name.charAt(name.length() - 1);
//            }
//        }
//        return result;
//    }
//
//    public static String getFormatVideoDuration(String duration) {
//        String formatDuration = "";
//        if (StringUtils.isBlank(duration)) {
//            return null;
//        }
//        if (duration.indexOf(".") > 0) {
//            String[] str = duration.split("\\.");
//            if (str.length > 1) {
//                formatDuration = str[0] + "分" + str[1] + "秒";
//            } else {
//                formatDuration = duration + "分钟";
//            }
//        } else {
//            formatDuration = duration + "分钟";
//        }
//        return formatDuration;
//    }
//
//    public static int getFormatVideoDuration1(String duration) {
//        String formatDuration = "";
//        if (StringUtils.isBlank(duration)) {
//            return 0;
//        }
//        duration = duration.trim();
//        if(duration.contains(" ")){
//            String[] arr = duration.split(" ");
//            String h = arr[0].substring(0,arr[0].length()-2);
//            String m = arr[1].substring(0,arr[1].length()-2);
//            System.out.println(h);
//            System.out.println(m);
//        }
//
//
//
//
//
//        return 0;
//    }
//
//    public static void main(String[] args) {
//        try {
//            System.out.println(getFormatVideoDuration1("2小时 04分钟"));
////            System.out.println(getFormatVideoDuration1("14分钟"));
////            System.out.println(getFormatVideoDuration1("2小时"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//}
