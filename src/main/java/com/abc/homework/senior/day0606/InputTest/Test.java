package com.abc.homework.senior.day0606.InputTest;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		FileCopy fileCopy = new FileCopy();

		String pathString = "/Users" + File.separator + "zishang" + File.separator + "Downloads" + File.separator + "code" + File.separator + "abc"
				+ File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "abc" + File.separator
				+ "homework" + File.separator + "senior" + File.separator + "day0606" + File.separator + "InputTest" + File.separator + "input"
				+ File.separator;

		String source = pathString + "input.doc";
		String target = pathString + "inputTest.doc";
		fileCopy.copy(source, target);

		String source1 = pathString + "input.txt";
		String target1 = pathString + "inputTest.txt";
		fileCopy.copy(source1, target1);

		String source2 = pathString + "input.txt";
		String target2 = pathString + "inputCat.txt";
		fileCopy.cat(source2, target2);
	}

}
