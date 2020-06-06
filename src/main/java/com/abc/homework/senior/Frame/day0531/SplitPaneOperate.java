package com.abc.homework.senior.Frame.day0531;

import javax.swing.*;
import java.awt.*;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/5/31. 9:36 AM
 */
public class SplitPaneOperate {
	public static void main(String[] args) {
		new SPFrame();
	}

}

class SPFrame extends JFrame {
	JPanel left = new JPanel();
	JPanel right = new JPanel();
	JSplitPane split = new JSplitPane();

	public SPFrame() {
		super("JSplitPane 演示");
		left.setBackground(new Color(230, 230, 230));
		right.setBackground(new Color(240, 240, 240));
		split.setOneTouchExpandable(true);
		split.setContinuousLayout(true);
		split.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		split.setDividerSize(6);
		split.setDividerLocation(400);
		split.setLeftComponent(left);
		split.setRightComponent(right);
		setContentPane(split);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		setVisible(true);
	}
}
