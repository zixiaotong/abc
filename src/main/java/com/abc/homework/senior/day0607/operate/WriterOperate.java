package com.abc.homework.senior.day0607.operate;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WriterOperate {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		try {
			String source = "/Users/zishang/Downloads/code/abc/src/main/java/com/abc/homework/senior/day0606/InputTest/" + File.separator + "input.txt";

			fos = new FileOutputStream(source);
			osw = new OutputStreamWriter(fos);
			osw.write("xxxxxxx");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				osw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
