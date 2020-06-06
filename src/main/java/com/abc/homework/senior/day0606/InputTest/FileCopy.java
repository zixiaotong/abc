package com.abc.homework.senior.day0606.InputTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public void copy(String source, String target) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] temp = new byte[1024];
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(target);
			try {
				int n;
				while ((n = fis.read(temp)) != -1) {
					fos.write(temp, 0, n);
				}
			} catch (IOException e) {
				System.out.println("写入失败");
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件找不到");
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}

	public void cat(String source, String target) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		byte[] temp = new byte[1024];
		try {
			fis = new FileInputStream(source);
			fos = new FileOutputStream(target, true);
			try {
				int n;
				while ((n = fis.read(temp)) != -1) {
					fos.write(temp, 0, n);
				}
			} catch (IOException e) {
				System.out.println("写入失败");
			}
		} catch (FileNotFoundException e) {
			System.out.println("文件找不到");
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	}
}
