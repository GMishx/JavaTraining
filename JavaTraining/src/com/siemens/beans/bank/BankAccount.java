package com.siemens.beans.bank;

public class BankAccount {

	private double ammount;

	public synchronized double getAmmount() {
		return ammount;
	}

	public synchronized BankAccount setAmmount(double ammount) {
		this.ammount = ammount;
		return this;
	}

	public synchronized boolean deposit(double ammount) {
		this.ammount += ammount;
		return true;
	}

	public synchronized boolean withdraw(double ammount) {
		if (this.ammount < ammount)
			return false;
		this.ammount -= ammount;
		return true;
	}

}
