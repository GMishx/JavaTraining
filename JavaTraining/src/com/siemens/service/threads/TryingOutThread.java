package com.siemens.service.threads;

public class TryingOutThread implements Runnable {

	int start = 0;
	int end = 10;

	public static void main(String[] args) {
		System.out.println("In main1");
		TryingOutThread t = new TryingOutThread();
		Thread theThread = new Thread(t);
		theThread.start();
		System.out.println("In main2");
		TryingOutThread t2 = new TryingOutThread();
		t2.start = 20;
		t2.end = 30;
		Thread theThread2 = new Thread(t2);
		theThread2.start();
		System.out.println("In main3");
		try {
			theThread.join();
			theThread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("In main4");
	}

	@Override
	public void run() {
		for (int i = start; i < end; i++) {
			System.out.println("Start: " + start + "=>" + i);
		}
	}

}
