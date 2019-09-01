package com.abc.utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-08-09 15:23
 **/
public class IntersectionUtils {

    /**
     * 测试简单交集
     *
     * @param args
     */
    public static void main(String[] args) {
//        retainAll();
        include();
    }

    /**
     * 查看交集
     */
    public static void retainAll() {
        List<Long> set1 = new ArrayList<>();
        List<Long> set2 = new ArrayList<>();
        set1.add(1L);
        set1.add(2L);
        set1.add(3L);
        set1.add(4L);
        set1.add(5L);
        set1.add(6L);

        set2.add(1L);
        set2.add(2L);
        set2.add(3L);
        set2.add(8L);
        //交集
        set1.retainAll(set2);
        System.out.println("交集是 " + set1);  //交集是 [c]
        System.out.println(set1.equals(set2));
    }

    public static void include() {
        String b = "4,5,6";// 套餐
        String a = "4,5,6,7";// 传过来的参数


        String c = "8,4,5,6,7";// 传过来的参数

        List<Long> list = Arrays.stream(c.split(",")).map(s -> Long.parseLong(s.trim())).collect(Collectors.toList());
        IntersectionUtils.sortById(list);
        System.out.println(list);
    }

    public static void sortById(List<Long> list) {
        Collections.sort(list, new Comparator<Long>() {
            @Override
            public int compare(Long u1, Long u2) {
                int id1 = u1.intValue();
                int id2 = u2.intValue();
                return id1 - id2;
            }
        });
    }
}
