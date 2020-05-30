package com.abc.homework.senior.Frame.Monitor.lesson4;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RepaintOperate {

	public static void main(String[] args) {
		new GraphicsFrame();
	}
}

class GraphicsFrame extends Frame {
	ArrayList<Shape> list = new ArrayList<Shape>();
	Button bt;

	public GraphicsFrame() {
		bt = new Button("画图");
		bt.addActionListener(new MyListener());
		this.add(bt, BorderLayout.NORTH);
		this.setBackground(new Color(240, 240, 240));
		this.setBounds(100, 100, 800, 600);
		this.setVisible(true);
	}

	class MyListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int type = (int) (Math.random() * 2);
			int x = (int) (Math.random() * 400) + 200;
			int y = (int) (Math.random() * 300) + 200;
			int width = (int) (Math.random() * 200);
			int height = (int) (Math.random() * 200);
			int r = (int) (Math.random() * 255);
			int g = (int) (Math.random() * 255);
			int b = (int) (Math.random() * 255);
			Shape s = null;
			if (type == 0) {
				s = new Rectangle(x, y, new Color(r, g, b), width, height);
			} else {
				s = new Circle(x, y, new Color(r, g, b), width);
			}
			list.add(s);
			repaint();
		}

	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (Shape s : list) {
			s.draw(g);
		}
	}

}
