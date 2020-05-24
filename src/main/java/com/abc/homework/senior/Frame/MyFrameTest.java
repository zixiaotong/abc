package com.abc.homework.senior.Frame;

import java.awt.*;

public class MyFrameTest extends Frame {
    private Panel p1, p2, p3, p4;
    MyFrameTest(String s, int x, int y, int w, int h) {
        super(s);
        setLayout(null);
        p1 = new Panel();
        p2 = new Panel();
        p3 = new Panel();
        p4 = new Panel();
        p1.setBounds(0, 0, w / 2, h / 2);
        p2.setBounds(0, h / 2, w / 2, h / 2);
        p3.setBounds(w / 2, 0, w / 2, h / 2);
        p4.setBounds(w / 2, h / 2, w / 2, h / 2);
        p1.setBackground(Color.blue);
        p2.setBackground(Color.green);
        p3.setBackground(Color.yellow);
        p4.setBackground(Color.MAGENTA);
        add(p1);
        add(p2);
        add(p3);
        add(p4);
        setBounds(x, y, w, h);
        setVisible(true);
    }
    public static void main(String[] args) {
        MyFrameTest f = new MyFrameTest("p", 100, 100, 300, 100);
    }

}
