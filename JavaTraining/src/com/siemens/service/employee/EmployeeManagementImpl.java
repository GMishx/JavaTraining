package com.siemens.service.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.siemens.beans.employee.*;
import com.siemens.dao.employee.*;
import com.siemens.exceptions.employee.InvalidEmployeeIdException;

public class EmployeeManagementImpl implements EmployeeManagement {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	Storable dao = new StorableImpl();
	
	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<>();
		double totalSal = 0.00;
		try {
			System.out.print("Enter the number of employees: ");
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				employees.add(getNextEmployee());
			}
			for (Employee emp : employees) {
				System.out.println(emp);
				totalSal += emp.getSalary();
			}
			System.out.println("Total sum: " + totalSal);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static Employee getNextEmployee() throws NumberFormatException, IOException {
		Employee emp;
		System.out.print("Enter the employee ID: ");
		int id = Integer.parseInt(br.readLine());
		emp = new Employee(id);
		System.out.print("Enter the employee Name: ");
		emp.setName(br.readLine());
		System.out.print("Enter the employee Salary: ");
		emp.setSalary(Double.parseDouble(br.readLine()));
		Address empAddress = getEmployeeAddress();
		emp.setEmployeeAddress(empAddress);
		System.out.println();
		return emp;
	}

	private static Address getEmployeeAddress() throws NumberFormatException, IOException {
		Address addr = new Address();
		System.out.print("Enter address ID: ");
		addr.setAddressID(Integer.parseInt(br.readLine()));
		System.out.print("Enter address line1: ");
		addr.setAddress1(br.readLine());
		System.out.print("Enter address line2: ");
		addr.setAddress2(br.readLine());
		System.out.print("Enter street: ");
		addr.setStreet(br.readLine());
		System.out.print("Enter city: ");
		addr.setCity(br.readLine());
		System.out.print("Enter zip code: ");
		addr.setZipCode(Integer.parseInt(br.readLine()));
		return addr;
	}

	@Override
	public void insertEmployee(Employee emp) {
		dao.insertEmployee(emp);
	}

	@Override
	public void deleteEmployee(int empId) throws InvalidEmployeeIdException {
		dao.deleteEmployee(empId);
	}

	@Override
	public void updateEmployee(Employee emp) {
		dao.updateEmployee(emp);
	}

	@Override
	public void fetchEmployeeById(int empId) throws InvalidEmployeeIdException {
		dao.fetchEmployeeById(empId);
	}

	@Override
	public void fetchAllEmployees() {
		dao.fetchAllEmployees();
	}

}
