package com.siemens.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.siemens.beans.User;

public class UserAnnotationTest {

	public static void main(String[] args) {

		// 1. load configuration file
		Configuration conf = new Configuration();
		conf.configure("/userhibernate.cfg.xml");

		// 2. Obtain the data source
		SessionFactory factory = conf.buildSessionFactory();

		// 3. Obtain the connection
		Session session = factory.openSession();

		User u = new User().setUserName("User2").setPassword("PasswordM").setAge(25);

		// 4. Start a transaction
		Transaction tx = session.beginTransaction();
		//tx.begin();

		// Fire the query
		session.save(u);

		// Save the changes
		tx.commit();

		// Close the connection
		session.close();
		
	}

}
