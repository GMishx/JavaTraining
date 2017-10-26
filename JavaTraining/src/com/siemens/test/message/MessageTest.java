package com.siemens.test.message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.siemens.beans.message.Message;
import com.siemens.service.message.ConsumerThread;
import com.siemens.service.message.ProducerThread;

public class MessageTest {

	public static void main(String[] args) {
		Message msg = new Message();

		ExecutorService exec = Executors.newFixedThreadPool(2);

		exec.execute(new ProducerThread(msg));
		exec.execute(new ConsumerThread(msg));

		exec.shutdown();

		/*Thread p = new Thread(new ProducerThread(msg));
		Thread c = new Thread(new ConsumerThread(msg));

		c.start();
		p.start();

		try {
			c.join();
			p.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
