package com.abc.homework.senior.Frame.Monitor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/5/30. 8:42 AM
 */
public class ActionEventOperate {
	public static void main(String[] args) {
		Frame f = new Frame("ActionEvent Operate");
		Button b1 = new Button("Start");
		Button b2 = new Button("Stop");
		Monitor monitor = new Monitor();
		b1.addActionListener(monitor);
		b2.addActionListener(monitor);
		b2.setActionCommand("game over");
		f.add(b1, "North");
		f.add(b2, "Center");
		f.setLocation(300, 200);
		f.pack();
		f.setVisible(true);
	}
}

class Monitor implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("A button has been pressed");
		System.out.println("The relative info is " + e.getActionCommand());
		Button b = (Button) e.getSource();
		System.out.println(b.getLabel());
	}
}