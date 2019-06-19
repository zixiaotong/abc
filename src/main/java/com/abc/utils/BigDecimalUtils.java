package com.abc.utils;

import java.math.BigDecimal;

/**
 * @author zishang
 */
public class BigDecimalUtils {

    /**
     * 对两个BigDecimal字段类型比较大小
     *
     * @param a
     * @param b
     */
    public static void bigDecimalCompareTo(BigDecimal a, BigDecimal b) {
        //使用compareTo方法比较
        //注意：a、b均不能为null，否则会报空指针
        if (a.compareTo(b) == -1) {
            System.out.println("a小于b");
        }
        if (a.compareTo(b) == 0) {
            System.out.println("a等于b");
        }
        if (a.compareTo(b) == 1) {
            System.out.println("a大于b");
        }
        if (a.compareTo(b) > -1) {
            System.out.println("a大于等于b");
        }
        if (a.compareTo(b) < 1) {
            System.out.println("a小于等于b");
        }
    }

    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(101);
        BigDecimal b = new BigDecimal(101);
        bigDecimalCompareTo(a, b);
//        price = price.multiply(new BigDecimal(coupon.getDiscount())).divide(new BigDecimal(10), 2, BigDecimal.ROUND_HALF_UP);
    }
}
