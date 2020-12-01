package com.abc.homework.senior.day0607.shape;

import java.io.*;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/6/7. 9:40 AM
 */
public class ObjectOutputTest {
	public static void main(String[] args) {
		ObjectOutputStream dos = null;
		try {
			File file = new File("/Users/zishang/Downloads/code/abc/src/main/java/com/abc/homework/senior/day0607/shape/object.data");
			FileOutputStream fos = new FileOutputStream(file);
			dos = new ObjectOutputStream(fos);
			dos.writeObject(new Circle("1", 10));
			dos.writeObject(new Circle("2", 5));
			dos.writeObject(new Rectangle("2", 5, 10));
		} catch (IOException e) {
			System.out.println("输出出错");
		} finally {
			if (dos != null) {
				try {
					dos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
