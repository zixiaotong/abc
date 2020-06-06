package com.abc.homework.senior.day0606.ThreadTest;

public class SaveMoney implements Runnable {

	private Account account;

	public SaveMoney(Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 2; i++) {
			account.save(2000);
			try {
				Thread.sleep(5);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
