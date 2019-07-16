package com.abc.utils;


import org.junit.Test;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-07-02 13:46
 **/
public class DoubleUtils {

    @Test
    public void compareTo() {
        String a = "143.08541";
        String b = "140.08541";
        /**
         * 相等返回0，大于返回1，小于返回-1.
         */
        System.out.println(Double.valueOf(a).compareTo(Double.valueOf(b)));
    }

    @Test
    public void change() {
        String a = "143.08541";
        System.out.println(Double.valueOf(a));
    }
}
