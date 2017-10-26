package com.siemens.service.bank;

import com.siemens.beans.bank.BankAccount;

public class DepositorThread implements Runnable {

	private BankAccount ba;
	private double ammount;

	public double getAmmount() {
		return ammount;
	}

	public DepositorThread setAmmount(double ammount) {
		this.ammount = ammount;
		return this;
	}

	public DepositorThread(BankAccount bankAccount) {
		this.ba = bankAccount;
	}

	@Override
	public void run() {
		synchronized (this.ba) {
			System.out.println(Thread.currentThread().getName() + "Trying to deposit " + this.getAmmount() + " units");
			boolean result = ba.deposit(this.getAmmount());
			try {
				Thread.sleep(550);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result)
				System.out
						.println(Thread.currentThread().getName() + "Deposit done, ballance: " + this.ba.getAmmount());
			else
				System.out
						.println(Thread.currentThread().getName() + "Deposit fail, ballance: " + this.ba.getAmmount());
		}
	}

}
