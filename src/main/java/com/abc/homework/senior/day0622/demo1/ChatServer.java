package com.abc.homework.senior.day0622.demo1;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends JFrame {
    public static final int PORT = 4001;
    JTextArea ta = new JTextArea();
    ServerSocket server = null;
    List<Client> clients = new ArrayList<Client>();

    public static void main(String[] args) {
        ChatServer s = new ChatServer();
        s.startServer();
    }

    public ChatServer() {
        this.getContentPane().add(ta, BorderLayout.CENTER);
        setBounds(200, 100, 200, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void startServer() {
        try {
            server = new ServerSocket(PORT);
            while (true) {
                Socket s = server.accept();
                clients.add(new Client(s));
                ta.append("A Client Join " + s.getInetAddress() + ":" + s.getPort() + "\n");
                ta.append("Client count: " + clients.size() + "\n\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

    }

    class Client implements Runnable {
        Socket s = null;

        public Client(Socket s) {
            this.s = s;
            (new Thread(this)).start();
        }

        public void send(String str) throws IOException {
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            dos.writeUTF(str);
        }

        public void dispose() {
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        @Override
        public void run() {
            try {
                DataInputStream dis = new DataInputStream(s.getInputStream());
                String str = dis.readUTF();
                while (str != null && str.length() != 0) {
                    String head = s.getInetAddress().getHostAddress();
                    head += "-" + s.getPort();
                    str = head + "说" + str;
                    for (int i = 0; i < clients.size(); i++) {
                        Client c = clients.get(i);
                        if (this != c) {
                            c.send(str);
                        }
                    }
                    str = dis.readUTF();
                }
            } catch (Exception e) {
                System.out.println("client quit");
                this.dispose();
            }

        }

    }
}
