package com.siemens.service.employee;

import com.siemens.beans.employee.Employee;
import com.siemens.exceptions.employee.InvalidEmployeeIdException;

public interface EmployeeManagement {
	void insertEmployee(Employee emp);
	void deleteEmployee(int empId) throws InvalidEmployeeIdException;
	void updateEmployee(Employee emp);
	void fetchEmployeeById(int empId) throws InvalidEmployeeIdException;
	void fetchAllEmployees();
}
