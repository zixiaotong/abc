package com.abc.homework.senior.Frame.Monitor.lesson4;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

	protected int x;
	protected int y;
	protected Color color;

	public Shape(int x, int y, Color color) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public abstract void draw(Graphics g);

}
