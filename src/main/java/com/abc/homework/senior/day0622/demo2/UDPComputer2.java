package com.abc.homework.senior.day0622.demo2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPComputer2 {
    public static int CLIENT_PORT = 4002;
    public static void main(String[] args) {
        try {

            String strSend = "Hello Computer1!";
            byte[] bufSend = strSend.getBytes();
            DatagramPacket packet = new DatagramPacket(bufSend, bufSend.length);
            DatagramSocket socket = new DatagramSocket(CLIENT_PORT);
            packet.setAddress(InetAddress.getByName("127.0.0.1"));
            packet.setPort(UDPComputer1.SERVER_PORT);
            socket.send(packet);
            byte[] bufReceive = new byte[1024];
            packet.setData(bufReceive);
            String strReceive = new String(bufReceive,0,packet.getLength());
            System.out.println(strReceive);
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
