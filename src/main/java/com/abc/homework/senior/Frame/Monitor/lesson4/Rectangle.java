package com.abc.homework.senior.Frame.Monitor.lesson4;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private int width;
	private int height;

	public Rectangle(int x, int y, Color color, int width, int height) {
		super(x, y, color);
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.drawRect(x - width / 2, y - height / 2, width, height);
		g.setColor(c);
	}

}
