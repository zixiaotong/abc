package com.abc.homework.senior.Frame.day0531.Thread;

/**
 * @author shanglei
 * @program:zcool-gogoup-manager
 * @date 2020/5/31. 10:23 AM
 */
public class EventNumberThread implements Runnable {
	@Override
	public void run() {
		for (int i = 1; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}

	public static void main(String[] args) {
		Thread thread1 = new Thread(new EventNumberThread(), "线程1");
		Thread thread2 = new Thread(new EventNumberThread(), "线程2");
		thread1.start();
		thread2.start();

		// EventNumberThread thread1 = new EventNumberThread();
		// EventNumberThread thread2 = new EventNumberThread();
		// thread1.start();
		// thread2.start();

		System.out.println("aaa");
		System.out.println("ddd");
		System.out.println("ccc");
		for (int i = 0; i < 10; i += 2) {
			System.out.println("main的线程" + Thread.currentThread().getName() + "  " + i);

		}
	}
}
