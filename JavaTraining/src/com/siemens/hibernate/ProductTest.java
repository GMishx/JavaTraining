package com.siemens.hibernate;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.siemens.beans.shop.Product;

public class ProductTest {

	public static void main(String[] args) {

		// 1. load configuration file
		Configuration conf = new Configuration();
		conf.configure(new File("src\\com\\siemens\\hibernate\\hibernate.cfg.xml"));

		// 2. Obtain the data source
		SessionFactory factory = conf.buildSessionFactory();

		// 3. Obtain the connection
		Session session = factory.openSession();

		Product p = new Product().setName("Galaxy Note 8").setPrice(68000.00).setDescription("Best note");

		// 4. Start a transaction
		Transaction tx = session.beginTransaction();
		tx.begin();

		// Fire the query
		session.save(p);

		// Save the changes
		tx.commit();
		
		// Close the connection
		session.close();

	}

}
