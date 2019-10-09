package com.abc.homework;

/**
 * @author shanglei
 * @date 2019/10/9 22:45
 * @describe 请编写程序，将”我” “爱” “北” “京”存入数组，然后正序和逆序输出。
 */
public class ArrayWork2 {

    public static void main(String[] args) {
        String[] str = {"我", "爱", "北", "京"};

        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i]);
        }
        System.out.println("");
        for (int i = str.length - 1; i >= 0; i--) {
            System.out.print(str[i]);
        }
    }

}
