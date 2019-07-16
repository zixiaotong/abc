package com.abc.utils;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-07-11 14:21
 **/
public class LongUtils {
    public static void main(String[] args) {
        compareTo();
    }

    public static void compareTo() {
        String a = "824.519";
//        相等返回0，大于返回1，小于返回-1.
//        System.out.println(Long.parseLong(a));
        System.out.println(Long.valueOf("824.0"));

    }
}
