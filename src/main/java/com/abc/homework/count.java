package com.abc.homework;

/**
 * @program:abc
 * @author:shanglei
 * @createtime:2019-11-09 19:18
 **/
public class count {

    public static int counter = 15;
    public int number = 13;

	public void counta(int a) {
		counter = counter + a;
		System.out.println("静态的值 " + counter);
		number = number + a;
		System.out.println("非静态的值 " + number);
	}

	public static class testcount {
		public static void main(String[] args) {
			count aa = new count();
			aa.counta(3);
			//18 16


			count bb = new count();
			bb.counta(2);
			// 20 15
		}
	}
}
