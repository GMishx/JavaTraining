package com.siemens.service.employee;

import java.sql.SQLException;
import java.util.ListIterator;

import com.siemens.beans.employee.Employee;
import com.siemens.exceptions.employee.InvalidEmployeeIdException;

public interface EmployeeManagement {
	int insertEmployee(Employee emp) throws SQLException;

	boolean deleteEmployee(int empId) throws InvalidEmployeeIdException, SQLException;

	boolean updateEmployee(Employee emp) throws SQLException;

	Employee fetchEmployeeById(int empId) throws InvalidEmployeeIdException, SQLException;

	ListIterator<Employee> fetchAllEmployees() throws SQLException;
}
