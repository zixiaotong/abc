package com.abc.homework.senior.day0607.ByteArrayStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayStreamTest {

	public static void main(String[] args) {
		String str = "ByteArrayOutputStream And ByteArrayInputStream Test";
		byte[] b = str.getBytes();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			baos.write(b);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				baos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		int i;
		while ((i = bais.read()) != -1) {
			System.out.print((char) i);
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("/Users/zishang/Downloads/code/abc/src/main/java/com/abc/homework/senior/day0607/ByteArrayStream/e7.txt");
			baos.writeTo(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
