package com.abc.homework.senior.Frame.day0531;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/5/31. 9:32 AM
 */
public class JFrameOperate {
	public static void main(String[] args) {
		new MyJframe();
	}
}

class MyJframe extends JFrame {
	JButton button = new JButton("退出程序");

	public MyJframe() {
		super("Swing窗口");
		this.setBounds(100, 100, 300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		c.add(button);
		button.addActionListener(new Monitor1());
		this.setVisible(true);
	}
}

class Monitor1 implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
