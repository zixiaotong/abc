package com.abc.homework.senior.day0607.shape;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/6/7. 9:32 AM
 */
public class Circle extends Shape {
	private int radius;

	public Circle(String name, int radius) {
		super(name);
		this.radius = radius;
	}

	@Override
	public String toString() {
		return super.toString() + ", 半径:" + radius;
	}

}
