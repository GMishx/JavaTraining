package com.siemens.test.bank;

import java.util.List;

import com.siemens.beans.bank.BankAccount;
import com.siemens.service.bank.DepositorThread;
import com.siemens.service.bank.WithdrawThread;

public class BankingApp {

	public static void main(String[] args) {
		List<BankAccount> accounts = new java.util.LinkedList<>();
		for (int i = 1000; i < 2000; i += 10) {
			accounts.add(new BankAccount().setAmmount(i));
		}

		Thread[] dt = new Thread[5];
		Thread[] wt = new Thread[5];
		for (int i = 0; i < 5; i++) {
			dt[i] = new Thread(new DepositorThread(accounts.get(i)).setAmmount(25));
			dt[i].setName("DT[" + i + "]");
			wt[i] = new Thread(new WithdrawThread(accounts.get(i)).setAmmount(accounts.get(i).getAmmount() + 25));
			wt[i].setName("WT[" + i + "]");
		}

		for (int i = 0; i < 5; i++) {
			dt[i].start();
			wt[i].start();
		}

		try {
			for (int i = 0; i < 5; i++) {
				dt[i].join();
				wt[i].join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Ballance at end");
		for (int i = 0; i < 5; i++) {
			System.out.println(accounts.get(i).getAmmount());
		}
	}

}
