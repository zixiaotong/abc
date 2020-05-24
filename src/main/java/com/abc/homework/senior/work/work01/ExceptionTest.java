package com.abc.homework.senior.work.work01;

import java.util.ArrayList;
import java.util.List;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            List list = new ArrayList();
            list.add("a");
            list.add("b");
            list.add("c");
            list.add("d");
            list.add("e");
            list.get(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("角标越界，产生异常");
        } finally {
            System.out.println("finally");
        }
        System.out.println("程序结束");
    }
}
