package com.siemens.service.threads;

import java.util.List;

public class MailThread extends Thread {
	private List<Integer> accId;

	private SmsThread sT;

	public MailThread(List<Integer> accs) {
		this.accId = accs;
	}

	@Override
	public void run() {
		System.out.println("Trying to send Mail");
		try {
			for (Integer acc : accId) {
				synchronized (accId) {
					System.out.println("Mail for: " + acc);
					//Thread.sleep(150);
					if (this.sT != null) {
						this.sT.getAcc().notify();
					}
					// accId.wait(150);
					accId.wait();
				}
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Sent Mail successfully!");
	}

	public SmsThread getsT() {
		return sT;
	}

	public void setsT(SmsThread sT) {
		this.sT = sT;
	}
	
	public List<Integer> getAcc(){
		return this.accId;
	}
}
