package com.abc.homework.senior.day0606.File;

import java.io.File;

public class SearchFiles {
	
	private String path;
	private String type;
	
	public SearchFiles(String path, String type) {
		this.path = path;
		this.type = type;
	}

	public void search() {
		File file = new File(path);
		if (!file.exists()) {
			System.out.println(path + "不存在");
			return;
		}
		if (!file.isDirectory()) {
			System.out.println(path + "不是文件夹");
			return;
		}
		search(file, type);
	}
	
	private void search(File file, String type) {
		File[] files = file.listFiles();
		for (File f : files) {
			if(f.isFile() && f.getName().endsWith("." + type)) {
				System.out.println(f.getPath());
			} else if (f.isDirectory()) {
				search(f, type);
			}
		}
	}
}
