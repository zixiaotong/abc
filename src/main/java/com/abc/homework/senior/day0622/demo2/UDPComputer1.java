package com.abc.homework.senior.day0622.demo2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPComputer1 {
    public static int SERVER_PORT = 4001;

    public static void main(String[] args) {
        try {
            byte[] bufReceive = new byte[1024];
            DatagramPacket packet = new DatagramPacket(bufReceive, bufReceive.length);
            DatagramSocket socket = new DatagramSocket(SERVER_PORT);
            socket.receive(packet);
            String str = new String(bufReceive, 0, packet.getLength());
            System.out.println(str);
            String strSend = "Hello Computer2!";
            byte[] bufSend = strSend.getBytes();
            packet.setData(bufSend, 0, bufSend.length);
            packet.setAddress(InetAddress.getByName("127.0.0.1"));
            packet.setPort(UDPComputer2.CLIENT_PORT);
            socket.send(packet);
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
