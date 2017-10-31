package com.siemens.test.shop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.siemens.beans.shop.Product;
import com.siemens.service.shop.ProductService;
import com.siemens.service.shop.ProductServiceImpl;

public class UpdateProductTest {

	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter db username: ");
			String user = br.readLine();
			System.out.print("Enter db password: ");
			String pass = br.readLine();
			ProductService service = new ProductServiceImpl(user, pass);
			Product p = new Product();
			System.out.print("Enter product id to be updated: ");
			p.setId(Integer.parseInt(br.readLine()));
			System.out.print("Enter new product Name: ");
			p.setName(br.readLine());
			System.out.print("Enter new product Price: ");
			p.setPrice(Double.parseDouble(br.readLine()));
			System.out.print("Enter new product Description: ");
			p.setDescription(br.readLine());
			service.updateProduct(p);
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
