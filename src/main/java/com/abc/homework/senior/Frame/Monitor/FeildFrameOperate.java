package com.abc.homework.senior.Frame.Monitor;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/5/30. 9:43 AM
 */
public class FeildFrameOperate {
	public static void main(String[] args) {
		new TextFeildFrameOperate();
	}
}

class TextFeildFrameOperate extends Frame {
	private TextField tf;

	public TextFeildFrameOperate() {
		tf = new TextField();
		tf.setEchoChar('*');
		tf.addActionListener(new TFActionListener());
		tf.addTextListener(new TFTextListener());
		this.add(tf);
		this.setLocation(300, 200);
		this.pack();
		this.setVisible(true);
	}

	class TFActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(tf.getText());
			tf.setText("");
		}
	}

	class TFTextListener implements TextListener {
		@Override
		public void textValueChanged(TextEvent e) {
			System.out.println("Change:");
			System.out.println(tf.getText());
		}
	}
}
