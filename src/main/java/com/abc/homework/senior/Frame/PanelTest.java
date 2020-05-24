package com.abc.homework.senior.Frame;

import java.awt.*;

public class PanelTest {
    public static void main(String[] args) {
        Frame frame = new Frame("FrameWithPannel");
        Panel panel = new Panel();
        frame.setLayout(null);
        frame.setBounds(100, 100, 300, 200);
        frame.setBackground(new Color(0, 0, 102));

        panel.setBounds(50, 50, 150, 100);
        panel.setBackground(Color.RED);
        frame.add(panel);
        frame.setVisible(true);

        // frame.setLocation(100, 300);
        // frame.setSize(300, 200);
        // frame.setResizable(false);

    }

}
