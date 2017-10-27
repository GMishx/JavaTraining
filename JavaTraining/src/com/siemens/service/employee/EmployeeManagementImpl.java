package com.siemens.service.employee;

import java.sql.SQLException;
import java.util.ListIterator;

import com.siemens.beans.employee.Employee;
import com.siemens.dao.employee.Storable;
import com.siemens.dao.employee.StorableImpl;
import com.siemens.exceptions.employee.InvalidEmployeeIdException;

public class EmployeeManagementImpl implements EmployeeManagement {
	
	private Storable dao;
	
	public EmployeeManagementImpl(String user, String password) throws ClassNotFoundException, SQLException {
		dao = new StorableImpl(user,password);
	}

	@Override
	public int insertEmployee(Employee emp) throws SQLException {
		return dao.insertEmployee(emp);
	}

	@Override
	public boolean deleteEmployee(int empId) throws InvalidEmployeeIdException, SQLException {
		return dao.deleteEmployee(empId);
	}

	@Override
	public boolean updateEmployee(Employee emp) throws SQLException {
		return dao.updateEmployee(emp);
	}

	@Override
	public Employee fetchEmployeeById(int empId) throws InvalidEmployeeIdException, SQLException {
		return dao.fetchEmployeeById(empId);
	}

	@Override
	public ListIterator<Employee> fetchAllEmployees() throws SQLException {
		return dao.fetchAllEmployees();
	}

}
