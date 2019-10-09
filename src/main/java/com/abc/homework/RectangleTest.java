package com.abc.homework;

/**
 * @author shanglei
 * @date 2019/10/9 23:18
 * @describe 类描述信息
 */
public class RectangleTest {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.length = 5;
        rectangle.width = 2;
        double perimeter = rectangle.getPerimeter();
        System.out.println("周长是：" + perimeter);
        double area = rectangle.getArea();
        System.out.println("面积是：" + area);
    }
}
