package com.abc.homework.senior.day0606.ThreadTest;

public class TakeMoney implements Runnable {

	private Account account;

	public TakeMoney(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			account.withdraw(1500);
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
