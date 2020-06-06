package com.abc.homework.senior.Frame.day0531;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/5/31. 9:38 AM
 */
public class ComboBoxDialogOperate {
	public static void main(String[] args) {
		new ComboBoxDialog();
	}
}

class ComboBoxDialog extends JDialog {
	private JComboBox comboBox;
	private JTextField textFiled;

	public ComboBoxDialog() {
		super(null, "组合使用", JDialog.DEFAULT_MODALITY_TYPE.APPLICATION_MODAL);
		textFiled = new JTextField(10);
		comboBox = new JComboBox();
		comboBox.addItem("小学");
		comboBox.addItem("中学");
		comboBox.addItem("大学");
		comboBox.addActionListener(new MonitorCombo1());
		this.setLayout(new GridLayout(2, 1));
		this.add(comboBox);
		this.add(textFiled);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setBounds(300, 400, 200, 100);
		this.setVisible(true);
	}

	class MonitorCombo1 implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String msg = (String) comboBox.getSelectedItem();
			textFiled.setText(msg);
		}
	}
}
