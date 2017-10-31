package com.siemens.test.shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ListIterator;

import com.siemens.beans.shop.Product;
import com.siemens.service.shop.ProductService;
import com.siemens.service.shop.ProductServiceImpl;

public class FetchAllProductsTest {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter db username: ");
			String user = br.readLine();
			System.out.print("Enter db password: ");
			String pass = br.readLine();
			ProductService service = new ProductServiceImpl(user, pass);
			ListIterator<Product> li = service.fetchAllProducts();
			while (li.hasNext()) {
				System.out.println(li.next());
			}
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
