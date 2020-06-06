package com.abc.homework.senior.day0606.ThreadTest;

public class Account {

	private int balance;
	private int maxBalance = 10000;

	public Account(int balance) {
		this.balance = balance;
	}

	public synchronized void save(int money) {
		while (balance + money > maxBalance) {
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		balance += money;
		System.out.println(Thread.currentThread().getName());
		System.out.println("save: " + money + "元" + ", balance: " + balance);
		this.notifyAll();
	}

	public synchronized void withdraw(int money) {
		while (money > balance) {
			try {
				this.wait();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		balance -= money;
		System.out.println(Thread.currentThread().getName());
		System.out.println("withdraw: " + money + "元" + ", balance: " + balance);
		this.notifyAll();
	}

}
