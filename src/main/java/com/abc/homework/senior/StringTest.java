package com.abc.homework.senior;

public class StringTest {

    public static void main(String[] args) {
        String hello = "hello";
        String hello1 = new String("hello");
        System.out.println(hello1 == hello1);
        System.out.println(hello.equals(hello1));
        System.out.println(hello.equalsIgnoreCase(hello1));
        System.out.println(hello.startsWith("h"));
        System.out.println(hello.endsWith("0"));

        System.out.println("-------------------------------");

        System.out.println(hello.indexOf("o"));
        System.out.println(hello.length());
        System.out.println(hello.charAt(2));
        System.out.println(hello.substring(0, 2));

        System.out.println("-------------------------------");

        char[] c = hello.toCharArray();
        for (char i : c) {
            System.out.println(i);
        }
        System.out.printf(hello.toLowerCase());
        System.out.printf(hello.toUpperCase());

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("s");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("s");

    }

}
