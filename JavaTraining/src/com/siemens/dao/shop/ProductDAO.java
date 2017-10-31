package com.siemens.dao.shop;

import java.sql.SQLException;
import java.util.ListIterator;

import com.siemens.beans.shop.Product;

public interface ProductDAO {
	int insertProduct(Product prod) throws SQLException;

	boolean deleteProduct(int prodId) throws SQLException;

	boolean updateProduct(Product prod) throws SQLException;

	Product fetchProductById(int prodId) throws SQLException;

	ListIterator<Product> fetchAllProducts() throws SQLException;
}
