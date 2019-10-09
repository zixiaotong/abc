package com.abc.homework;

import java.util.Scanner;

/**
 * @author shanglei
 * @date 2019/10/9 22:14
 * @describe 编写程序，从键盘输入一个 0~99999 之间的任意数，判断输入的数是几位数？
 */
public class BaseWork4 {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入0~99999 之间的任意数");
            String str = scanner.nextLine();
            if (!str.matches("\\d+")) {
                System.out.println("请输入数字");
                return;
            }
            int num = Integer.parseInt(str);
            if (num < 0 || num > 99999) {
                System.out.println("请输入0~99999 之间的任意数");
                return;
            }
            System.out.println("输入的位数是：" + str.length() + " 位数");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
