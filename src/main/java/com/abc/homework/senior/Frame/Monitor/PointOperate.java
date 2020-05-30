package com.abc.homework.senior.Frame.Monitor;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/5/30. 10:40 AM
 */
public class PointOperate {
	public static void main(String[] args) {
		new PointFrame();
	}
}

class PointFrame extends Frame {
	public PointFrame() {
		setBounds(200, 200, 400, 320);
		this.addWindowListener(new WindowMonitor());
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		Color c = g.getColor();
		g.setColor(Color.red);
		g.fillOval(50, 50, 30, 30);
		g.setColor(Color.green);
		g.fillRect(80, 80, 40, 40);
		g.drawRect(120, 120, 50, 100);
		g.setColor(Color.blue);
		g.drawOval(120, 120, 50, 100);
	}

	class WindowMonitor extends WindowAdapter {
		@Override
		public void windowClosing(WindowEvent e) {
			super.windowClosing(e);
			setVisible(false);
			System.exit(0);
		}
	}

}
