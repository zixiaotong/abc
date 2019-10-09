package com.abc.homework;

/**
 * @author shanglei
 * @date 2019/10/9 22:33
 * @describe 创建一维数组，存放学生的6科成绩，计算总分和平均分。
 */
public class ArrayWork1 {
    public static void main(String[] args) {
        int[] grade = {34, 76, 45, 86, 65};
        double sum = 0;
        for (int i = 0; i < grade.length; i++) {
            sum += grade[i];
        }
        System.out.println("总分：" + sum);
        System.out.println("平均分：" + sum / grade.length);
    }
}
