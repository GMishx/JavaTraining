package com.siemens.test.threads;

public class ThreadWithLambda {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Yeah!");
			}
		});
		Thread t2 = new Thread(() -> System.out.println("Yeah again!"));

		t1.start();
		t2.start();
	}

}
