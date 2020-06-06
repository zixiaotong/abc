package com.abc.homework.senior.day0606.ThreadTest;

public class Test {

	public static void main(String[] args) {
		Account account = new Account(8000);
		Thread thread1 = new Thread(new TakeMoney(account), "son1");
		Thread thread2 = new Thread(new TakeMoney(account), "son2");
		Thread thread3 = new Thread(new TakeMoney(account), "son3");
		Thread thread4 = new Thread(new SaveMoney(account), "father");
		Thread thread5 = new Thread(new SaveMoney(account), "mother");
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
	}

}
