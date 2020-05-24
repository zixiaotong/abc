package com.abc.homework.senior.exception;

public class ExceptionTest {
    public static void main(String[] args) {
        try {
            int a = 20;
            int b = 0;
            int c = a / b;
            System.out.println(c);
        } catch (ArithmeticException e) {
            System.out.println("除数为零，产生异常");
        }
        System.out.println("程序结束");
        try {
            System.out.println("除法操作" + div(10, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int div(int i, int j) throws Exception {
        int temp = i / j;
        return temp;
    }
}
