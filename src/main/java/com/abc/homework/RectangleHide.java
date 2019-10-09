package com.abc.homework;

/**
 * @author shanglei
 * @date 2019/10/9 22:56
 * @describe 设计一个矩形类，有长和宽两个属性，以及计算面积和周长两个方法，再定义一个Test类，
 * 在Test类的主方法中定义矩形类的对象，计算矩形面积和周长并输出。要求：类的属性实现数据隐藏。
 */
public class RectangleHide {
    private int width;
    private int length;
    public int getWidth() {
        return this.width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getLength() {
        return this.length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    /**
     * 计算周长
     */
    public double getPerimeter() {
        return length * 2 + width * 2;
    }
    /**
     * 计算面积
     */
    public double getArea() {
        return length * width;
    }
}


