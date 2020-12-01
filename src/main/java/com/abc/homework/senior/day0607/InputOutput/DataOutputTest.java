package com.abc.homework.senior.day0607.InputOutput;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataOutputTest {

	public static void main(String[] args) {
		DataOutputStream dos=null;
		try{
			File file=new File("/Users/zishang/Downloads/code/abc/src/main/java/com/abc/homework/senior/day0606/InputTest/input/input.txt");
			FileOutputStream fos=new FileOutputStream(file);
			dos=new DataOutputStream(fos);
			dos.writeBoolean(true);
			dos.writeInt(10);
			dos.writeFloat((float)28.5);
			dos.writeDouble((double)36.5);
			dos.writeUTF("DataOutputStream");
		}catch(IOException e){
			System.out.println("输出错误");
		}finally{
			if(dos!=null){
				try{
					dos.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}

	}

}
