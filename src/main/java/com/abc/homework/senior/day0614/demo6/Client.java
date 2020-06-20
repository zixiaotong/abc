package com.abc.homework.senior.day0614.demo6;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", Server.TCP_PORT);
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            System.out.println(dis.readUTF());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str = br.readLine();
            dos.writeUTF(str);
            dos.close();
            dis.close();
            s.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
