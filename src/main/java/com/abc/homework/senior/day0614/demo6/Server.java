package com.abc.homework.senior.day0614.demo6;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static int TCP_PORT = 4000;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(TCP_PORT);
            while (true) {
                Socket s = ss.accept();
                InetAddress address = s.getInetAddress();
                System.out.print("A Client Connected IP");
                System.out.print(address.getHostAddress());
                System.out.println(" PORT:" + s.getPort());
                OutputStream os = s.getOutputStream();
                DataOutputStream dos = new DataOutputStream(os);
                InputStream is = s.getInputStream();
                DataInputStream dis = new DataInputStream(is);
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                String str = br.readLine();
                dos.writeUTF(str);
                System.out.println(dis.readUTF());
                dos.close();
                dis.close();
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
