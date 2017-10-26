package com.siemens.service.message;

import com.siemens.beans.message.Message;

public class ConsumerThread implements Runnable {

	private Message msg;

	public ConsumerThread(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		System.out.println("In Consumer thread");
		synchronized (msg) {
			if (msg.getMessage() == null) {
				try {
					msg.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Message recieved: " + msg.getMessage());
		}
	}

}
