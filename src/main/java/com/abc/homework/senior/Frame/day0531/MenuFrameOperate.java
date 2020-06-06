package com.abc.homework.senior.Frame.day0531;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/5/31. 9:53 AM
 */
public class MenuFrameOperate {
	public static void main(String[] args) {
		new MenuFrame();
	}
}

class MenuFrame extends JFrame implements ActionListener {
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("Background");
	JMenuItem menuItem1 = new JMenuItem("Red");
	JMenuItem menuItem2 = new JMenuItem("Green");
	JMenuItem menuItem3 = new JMenuItem("Blue");
	JToolBar toolBar = new JToolBar();
	JButton button1 = new JButton("Yellow");
	JButton button2 = new JButton("White");

	public MenuFrame() {
		this.setBounds(400, 200, 300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menu.add(menuItem1);
		menu.add(menuItem2);
		menu.add(menuItem3);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		menuItem1.addActionListener(this);
		menuItem2.addActionListener(this);
		menuItem3.addActionListener(this);
		this.setVisible(true);
		button1.addActionListener(this);
		button2.addActionListener(this);
		toolBar.add(button1);
		toolBar.add(button2);
		this.add(toolBar, BorderLayout.NORTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Container c = this.getContentPane();
		if (e.getSource() == menuItem1) {
			c.setBackground(Color.RED);
		} else if (e.getSource() == menuItem2) {
			c.setBackground(Color.GREEN);
		} else if (e.getSource() == menuItem3) {
			c.setBackground(Color.BLUE);
		} else if (e.getSource() == button1) {
			c.setBackground(Color.YELLOW);
		} else if (e.getSource() == button2) {
			c.setBackground(Color.WHITE);
		}
	}

}
