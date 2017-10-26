package com.siemens.test.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.siemens.beans.employee.*;

public class EmployeeCallableTest {

	public static void main(String[] args) {
		ExecutorService ser = Executors.newFixedThreadPool(2);
		
		Future<Employee> f = ser.submit(new Callable<Employee>() {

			@Override
			public Employee call() throws Exception {
				return new Employee(1).setName("SRS").setSalary(15000).setEmployeeAddress(new Address().setCity("Machilipatnam"));
			}
			
		});
		
		try {
			System.out.println(f.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ser.shutdown();
	}

}
