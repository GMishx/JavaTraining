package com.siemens.test.shop;

import com.siemens.beans.shop.ProductDiscount;
import com.siemens.service.shop.ApplyDiscountThread;
import com.siemens.service.shop.ProductDiscountService;
import com.siemens.service.shop.ProductDiscountServiceImpl;
import com.siemens.service.shop.ValidateDiscountThread;

public class ProductDiscountThreadTest {

	public static void main(String[] args) {
		ProductDiscount pd = new ProductDiscount();
		ProductDiscountService prodSer = new ProductDiscountServiceImpl();
		Thread vdT = new Thread(new ValidateDiscountThread(pd, prodSer));
		Thread adT = new Thread(new ApplyDiscountThread(pd, prodSer));
		adT.start();
		vdT.start();
		try {
			adT.join();
			vdT.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
