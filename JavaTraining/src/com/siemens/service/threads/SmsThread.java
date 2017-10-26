package com.siemens.service.threads;

import java.util.List;

public class SmsThread extends Thread {

	private List<Integer> accId;

	private MailThread mT;

	public SmsThread(List<Integer> accs) {
		this.accId = accs;
	}

	@Override
	public void run() {
		System.out.println("Trying to send SMS");
		try {
			for (Integer acc : accId) {
				synchronized (accId) {
					System.out.println("SMS for: " + acc);
					//Thread.sleep(150);
					if (this.mT != null) {
						this.mT.getAcc().notify();
					}
					// accId.wait(150);
					accId.wait();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sent SMS successfully!");
	}

	public MailThread getmT() {
		return mT;
	}

	public void setmT(MailThread mT) {
		this.mT = mT;
	}
	
	public List<Integer> getAcc(){
		return this.accId;
	}

}
