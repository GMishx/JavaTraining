package com.siemens.service.message;

import com.siemens.beans.message.Message;

public class ProducerThread implements Runnable {

	private Message msg;

	public ProducerThread(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		System.out.println("In producer thread");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		synchronized (msg) {
			msg.setMessage("Hello Sri Ranga Sai Yandapalli");
			msg.notify();
		}
	}

}
