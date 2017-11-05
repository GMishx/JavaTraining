package com.siemens.service.shop;

import com.siemens.beans.shop.ProductDiscount;

public class ProductDiscountServiceImpl implements ProductDiscountService {

	@Override
	public void validateDiscount(ProductDiscount pd) {
		synchronized (pd) {
			pd.setName("A product");
			pd.setDiscount(25);
			pd.notify();
		}
	}

	@Override
	public void applyDiscount(ProductDiscount pd) {
		synchronized (pd) {
			if ((pd.getName() == null) || (pd.getDiscount() <= 0.0)) {
				try {
					pd.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Product " + pd.getName() + " updated with discount: " + pd.getDiscount());
			}
		}
	}

}
