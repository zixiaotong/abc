package com.abc.homework.senior.day0607.shape;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/6/7. 9:41 AM
 */
public class Rectangle extends Shape {
    private int length;
    private int width;
    public Rectangle(String name, int length, int width) {
        super(name);
        this.length = length;
        this.width = width;
    }
    @Override
    public String toString() {
        return super.toString() + ",长:" + length + ",宽:" + width;
    }

}
