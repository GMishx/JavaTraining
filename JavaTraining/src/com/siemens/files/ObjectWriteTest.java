package com.siemens.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.siemens.beans.employee.Address;
import com.siemens.beans.employee.Employee;

public class ObjectWriteTest {

	public static void main(String[] args) {
		// writer();
		reader();
	}

	static void writer() {
		Employee emp = new Employee(1).setName("Mr. X").setSalary(35000).setEmployeeAddress(new Address()
				.setAddressID(1).setAddress1("A-970").setStreet("Faizabad").setCity("Lucknow").setZipCode(226016));
		File outputStream = new File("D:" + File.separator + "employee.bin");
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(outputStream));
			oos.writeObject(emp);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void reader() {
		File inputStream = new File("D:" + File.separator + "employee.bin");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(inputStream));
			Employee emp = (Employee) ois.readObject();
			ois.close();
			if (emp != null) {
				System.out.println(emp);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
