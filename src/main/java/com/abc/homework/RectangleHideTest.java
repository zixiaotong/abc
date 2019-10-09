package com.abc.homework;

/**
 * @author shanglei
 * @date 2019/10/9 23:18
 * @describe 类描述信息
 */
public class RectangleHideTest {
    public static void main(String[] args) {
        RectangleHide rectangle = new RectangleHide();
        rectangle.setWidth(2);
        rectangle.setLength(5);
        double perimeter = rectangle.getPerimeter();
        System.out.println("周长是：" + perimeter);
        double area = rectangle.getArea();
        System.out.println("面积是：" + area);
    }
}
