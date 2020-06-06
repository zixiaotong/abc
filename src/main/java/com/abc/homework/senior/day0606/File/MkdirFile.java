package com.abc.homework.senior.day0606.File;

import java.io.File;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/6/6. 10:58 AM
 */
public class MkdirFile {

	public static void main(String[] args) {
		// /Users/zishang/Downloads/code/abc/src/main/java/com/abc/homework/senior/Frame/day0606/File
		String pathString = "/Users" + File.separator + "zishang" + File.separator + "Downloads" + File.separator + "code" + File.separator + "abc";
		String fileName = "test.txt";
		File pathFile = new File(pathString);
		if (!pathFile.exists()) {
			pathFile.mkdir();
		}
		File pathFile2 = new File(pathString, fileName);
		try {
			pathFile2.createNewFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
