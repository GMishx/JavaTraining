package com.siemens.test.threads;

import java.util.ArrayList;
import java.util.List;

import com.siemens.service.threads.*;

public class ThreadTest {

	public static void main(String[] args) {
		List<Integer> accs = new ArrayList<Integer>();
		for (int i = 10000; i < 10500; i += 5) {
			accs.add(i);
		}

		SmsThread sT = new SmsThread(accs);
		MailThread mT = new MailThread(accs);
		
		sT.setmT(mT);
		mT.setsT(sT);
		
		sT.start();
		mT.start();
		
		try {
			sT.join();
			synchronized (mT.getAcc()) {
				mT.getAcc().notify();				
			}
			mT.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
		}
	}

}
