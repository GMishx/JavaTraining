package com.siemens.service.shop;

import java.sql.SQLException;
import java.util.ListIterator;

import com.siemens.beans.shop.Product;

public interface ProductService {
	int addProduct(Product prod) throws SQLException;

	boolean deleteProduct(int prodId) throws SQLException;

	boolean updateProduct(Product prod) throws SQLException;

	Product fetchProductById(int prodId) throws SQLException;

	ListIterator<Product> fetchAllProducts() throws SQLException;
}
