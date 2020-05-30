package com.abc.homework.senior.Frame.Monitor.lesson4;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {

	private int radius;

	public Circle(int x, int y, Color color, int radius) {
		super(x, y, color);
		this.radius = radius;
	}

	@Override
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
		g.setColor(c);
	}

}
