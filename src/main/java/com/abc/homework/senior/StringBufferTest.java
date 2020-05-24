package com.abc.homework.senior;

public class StringBufferTest {
    public static void main(String[] args) {
//        StringBuilder stringBuilder = new StringBuilder("abc");
//        boolean flag = true;
//        System.out.println(stringBuilder.append(flag));
//
//        String s1 = "hello";
//        String s2 = "world";
//
//        System.out.println(stringBuilder.append(s1).append(s2));
//        System.out.println(stringBuilder.insert(3, false));
//
//        char[] chars = {1, 3, 4, 5, 666, 77, 7, 67, 97, 43};
//        System.out.println(stringBuilder.insert(2, chars, 1, 5));
//
//        System.out.println(stringBuilder.deleteCharAt(5));
//        System.out.println(stringBuilder.delete(1, 5));
//        System.out.println(stringBuilder.reverse());
//        stringBuilder.setCharAt(5, 'h');
//
//        System.out.println(stringBuilder);

        StringBuffer a = new StringBuffer("a");
        StringBuffer b = new StringBuffer("b");
        append(a, b);
//        System.out.println(a);
//        System.out.println(b);


//        int count = 66;
//        fun(count);
//        System.out.println(count);

        Long l = 66L;
        funL(l);
        System.out.println(l);
//        String str = "66";
//        funStr(str);
//        System.out.println(str);
    }

    public static void funL(Long count) {
        count = 666L;
    }

    public static void funStr(String count) {
        count = "666";
    }

    public static void fun(int count) {
        count = 666;
    }

    public static void append(StringBuffer a, StringBuffer b) {
        a.append(b);
        b = a;
    }
}
