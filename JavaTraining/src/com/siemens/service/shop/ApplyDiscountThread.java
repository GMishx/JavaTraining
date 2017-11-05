package com.siemens.service.shop;

import com.siemens.beans.shop.ProductDiscount;

public class ApplyDiscountThread implements Runnable {

	private ProductDiscount prod;
	private ProductDiscountService prodSer;

	public ApplyDiscountThread(ProductDiscount prod, ProductDiscountService prodSer) {
		super();
		this.prod = prod;
		this.prodSer = prodSer;
	}

	@Override
	public void run() {
		prodSer.applyDiscount(prod);
	}

}
