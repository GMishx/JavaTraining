package com.siemens.service.shop;

import com.siemens.beans.shop.ProductDiscount;

public interface ProductDiscountService {
	void validateDiscount(ProductDiscount pd);

	void applyDiscount(ProductDiscount pd);
}
