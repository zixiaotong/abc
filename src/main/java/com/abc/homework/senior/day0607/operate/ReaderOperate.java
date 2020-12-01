package com.abc.homework.senior.day0607.operate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class ReaderOperate {
	public static void main(String[] args) {
//		FileInputStream fis = null;
//		InputStreamReader isr = null;
//		String source = "/Users/zishang/Downloads/code/abc/src/main/java/com/abc/homework/senior/day0606/InputTest/" + File.separator + "input.txt";
//		try {
//			fis = new FileInputStream(source);
//			isr = new InputStreamReader(fis);
//			int a;
//			while ((a = isr.read()) != -1) {
//				System.out.print((char) a);
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}


		int number = new Random().nextInt(2);
		System.out.println(number);
	}
}
