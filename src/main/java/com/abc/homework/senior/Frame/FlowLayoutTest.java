package com.abc.homework.senior.Frame;

import java.awt.*;

public class FlowLayoutTest {
    public static void main(String[] args) {
        Frame f = new Frame("FrameWithFlowLayout");
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 10, 40);
        f.setLayout(flowLayout);
        f.setLocation(300, 400);
        f.setSize(300, 200);
        f.setBackground(new Color(204, 204, 255));
        for (int i = 1; i < 7; i++) {
            Button b = new Button("Button" + i);
            f.add(b);
        }
        f.setVisible(true);
    }

}
