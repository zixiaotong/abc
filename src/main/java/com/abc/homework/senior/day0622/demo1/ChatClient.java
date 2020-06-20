package com.abc.homework.senior.day0622.demo1;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClient extends JFrame implements ActionListener {
    JTextArea ta = new JTextArea();
    JTextField tf = new JTextField();
    Socket s = null;

    public static void main(String[] args) throws Exception {
        ChatClient cc = new ChatClient();
    }

    public ChatClient() {

        try {
            s = new Socket("127.0.0.1", ChatServer.PORT);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }
        createForm();
        Thread t = new Thread(new ReceiveThread());
        t.start();
    }

    public void createForm() {
        this.getContentPane().add(ta, BorderLayout.CENTER);
        this.getContentPane().add(tf, BorderLayout.SOUTH);
        tf.addActionListener(this);
        setBounds(300, 300, 300, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        tf.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = tf.getText();
        if (str.trim().length() == 0) {
            return;
        }

        send(str);
        tf.setText("");
        ta.append("说" + str + "\n");
    }

    public void send(String str) {

        try {
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(str);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    class ReceiveThread implements Runnable {

        @Override
        public void run() {
            if (s == null) {
                return;
            }
            try {
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = dis.readUTF();
                while (str != null && str.length() != 0) {
                    ChatClient.this.ta.append(str + "\n");
                    str = dis.readUTF();
                }
            } catch (Exception e) {
            }

        }

    }
}
