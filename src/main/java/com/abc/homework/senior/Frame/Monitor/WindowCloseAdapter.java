package com.abc.homework.senior.Frame.Monitor;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/5/30. 10:36 AM
 */
public class WindowCloseAdapter {
	public static void main(String[] args) {
		new WAFrame();
	}
}

class WAFrame extends Frame {
	WAFrame() {
		setBounds(300, 300, 300, 200);
		this.addWindowListener(new WindowMonitor());
		setVisible(true);
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
