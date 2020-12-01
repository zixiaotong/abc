package com.abc.homework.senior.day0607.InputOutput;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

public class DataInputTest {

	public static void main(String[] args) {
		DataInputStream dis = null;
		try {
			File file = new File("/Users/zishang/Downloads/code/abc/src/main/java/com/abc/homework/senior/day0606/InputTest/input/input.txt");
			FileInputStream fis = new FileInputStream(file);
			dis = new DataInputStream(fis);
			System.out.println(dis.readBoolean());
			System.out.println(dis.readInt());
			System.out.println(dis.readFloat());
			System.out.println(dis.readDouble());
			System.out.println(dis.readUTF());
		} catch (IOException e) {
			System.out.println("输出错误");
		} finally {
			if (dis != null) {
				try {
					dis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
