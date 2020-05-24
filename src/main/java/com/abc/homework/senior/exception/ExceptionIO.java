package com.abc.homework.senior.exception;

import java.io.FileInputStream;
import java.io.IOException;

public class ExceptionIO {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("/Users/shanglei/file.txt");
        } catch (IOException e) {
            System.out.println("文件找不到，产生异常");
        } finally {
            System.out.println("必须会执行的代码");
        }
    }

}
