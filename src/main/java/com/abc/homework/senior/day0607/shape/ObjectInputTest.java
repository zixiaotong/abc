package com.abc.homework.senior.day0607.shape;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/6/7. 9:41 AM
 */
public class ObjectInputTest {
	public static void main(String[] args) {
		ObjectInputStream ois = null;
		try {
			File file = new File("/Users/zishang/Downloads/code/abc/src/main/java/com/abc/homework/senior/day0607/shape/object.data");
			FileInputStream fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			Shape[] s = new Shape[3];
			for (int i = 0; i < 3; i++) {
				s[i] = (Shape) ois.readObject();
				System.out.println(s[i]);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Shape类没有定义！");
		} catch (IOException e) {
			System.out.println("输出出错！");
		} finally {
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
