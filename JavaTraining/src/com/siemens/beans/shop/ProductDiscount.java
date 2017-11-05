package com.siemens.beans.shop;

public class ProductDiscount {
	private String name;
	private double discount;

	public synchronized String getName() {
		return name;
	}

	public synchronized double getDiscount() {
		return discount;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized void setDiscount(double discount) {
		this.discount = discount;
	}

}
