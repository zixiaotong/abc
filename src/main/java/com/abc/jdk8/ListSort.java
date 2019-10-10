package com.abc.jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-10-10 19:13
 **/
public class ListSort {
    public static void main(String[] args) {
        List<Long> idListSort = Arrays.asList(0L, 3L, 2L, 1L);
        // 正序
        idListSort.sort(Comparator.naturalOrder());
        System.out.println(idListSort);
        // 逆序
        idListSort.sort(Comparator.reverseOrder());
        System.out.println(idListSort);
    }
}
