package com.abc.homework.senior.exception;

public class MyException extends Exception {
    public MyException(String msg) {
        super(msg);
    }

    public static void main(String[] args) {
        try {
            throw new MyException("自定义异常");
        } catch (MyException e) {
            System.out.println(e);
        }
    }
}
