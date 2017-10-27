package com.siemens.dao.employee;

import java.sql.SQLException;
import java.util.ListIterator;

import com.siemens.beans.employee.Employee;
import com.siemens.exceptions.employee.InvalidEmployeeIdException;

public interface Storable {
	int insertEmployee(Employee emp) throws SQLException;
	boolean deleteEmployee(int empId) throws InvalidEmployeeIdException, SQLException;
	boolean updateEmployee(Employee emp) throws SQLException;
	Employee fetchEmployeeById(int empId) throws InvalidEmployeeIdException, SQLException;
	ListIterator<Employee> fetchAllEmployees() throws SQLException;
}
