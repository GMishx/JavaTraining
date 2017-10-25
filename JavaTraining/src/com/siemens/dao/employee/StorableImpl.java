package com.siemens.dao.employee;

import com.siemens.beans.employee.Employee;
import com.siemens.exceptions.employee.InvalidEmployeeIdException;

public class StorableImpl implements Storable {

	@Override
	public void insertEmployee(Employee emp) {
		System.out.println("Inserting employee");

	}

	@Override
	public void deleteEmployee(int empId) throws InvalidEmployeeIdException {
		if (empId <= 0) {
			throw new InvalidEmployeeIdException("Employee ID cannot be <= 0!");
		}
		System.out.println("Deleting employee");

	}

	@Override
	public void updateEmployee(Employee emp) {
		System.out.println("Updating employee");

	}

	@Override
	public void fetchEmployeeById(int empId) throws InvalidEmployeeIdException {
		if (empId <= 0) {
			throw new InvalidEmployeeIdException("Employee ID cannot be <= 0!");
		}
		System.out.println("Fetching employee");
	}

	@Override
	public void fetchAllEmployees() {
		System.out.println("Fetching all employees");
	}
}
