package com.abc.homework.senior.exception;

public class ExceptionThis extends Exception {
    public static void main(String[] args) {
        try {
            throw new Exception("自己抛出异常");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
