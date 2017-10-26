package com.siemens.service.bank;

import com.siemens.beans.bank.BankAccount;

public class WithdrawThread implements Runnable {

	private BankAccount ba;
	private double ammount;

	public double getAmmount() {
		return ammount;
	}

	public WithdrawThread setAmmount(double ammount) {
		this.ammount = ammount;
		return this;
	}

	public WithdrawThread(BankAccount bankAccount) {
		this.ba = bankAccount;
	}

	@Override
	public void run() {
		synchronized (this.ba) {
			System.out.println(Thread.currentThread().getName() + "Trying to withdraw " + this.getAmmount() + " units");
			boolean result = ba.withdraw(this.getAmmount());
			try {
				Thread.sleep(550);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (result)
				System.out
						.println(Thread.currentThread().getName() + "Withdraw done, ballance: " + this.ba.getAmmount());
			else
				System.out
						.println(Thread.currentThread().getName() + "Withdraw fail, ballance: " + this.ba.getAmmount());
		}
	}

}
