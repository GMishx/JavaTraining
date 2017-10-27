package com.siemens.dao.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;

import com.siemens.beans.employee.Address;
import com.siemens.beans.employee.Employee;
import com.siemens.exceptions.employee.InvalidEmployeeIdException;

public class StorableImpl implements Storable {

	Connection con;

	public StorableImpl(String user, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/siemensdb", user, password);
	}

	public StorableImpl(Connection con) {
		this.con = con;
	}

	@Override
	public int insertEmployee(Employee emp) throws SQLException {
		PreparedStatement stmEmp;
		PreparedStatement stmAdd;
		stmAdd = con
				.prepareStatement(
						"INSERT INTO `siemensdb`.`address`\r\n"
								+ "(`address1`,`address2`,`Street`,`City`,`Zipcode`)\r\n" + "VALUES (?,?,?,?,?);",
						PreparedStatement.RETURN_GENERATED_KEYS);

		Address empAddress = emp.getEmployeeAddress();
		stmAdd.setString(1, empAddress.getAddress1());
		stmAdd.setString(2, empAddress.getAddress2());
		stmAdd.setString(3, empAddress.getStreet());
		stmAdd.setString(4, empAddress.getCity());
		stmAdd.setInt(5, empAddress.getZipCode());

		stmAdd.executeUpdate();

		ResultSet rs = stmAdd.getGeneratedKeys();

		int rowId = -1;

		if (rs.next()) {
			rowId = rs.getInt(1);
		}

		if (rowId < 0) {
			return -1;
		}

		empAddress.setAddressID(rowId);

		stmEmp = con.prepareStatement("INSERT INTO `siemensdb`.`employee`\r\n"
				+ "(`EmployeeName`,`Salary`,`AddressID`)\r\n" + "VALUES (?,?,?);",
				PreparedStatement.RETURN_GENERATED_KEYS);
		stmEmp.setString(1, emp.getName());
		stmEmp.setDouble(2, emp.getSalary());
		stmEmp.setInt(3, rowId);

		stmEmp.executeUpdate();

		rs = stmEmp.getGeneratedKeys();

		if (rs.next()) {
			int newID = rs.getInt(1);
			emp.setId(newID);
			return newID;
		}

		return -1;
	}

	@Override
	public boolean deleteEmployee(int empId) throws InvalidEmployeeIdException, SQLException {
		if (empId <= 0) {
			throw new InvalidEmployeeIdException("Employee ID cannot be <= 0!");
		}

		PreparedStatement stm;
		stm = con.prepareStatement("DELETE FROM `siemensdb`.`employee`\r\n" + "WHERE\r\n" + "EmployeeID = ?;");

		stm.setInt(1, empId);

		int result = stm.executeUpdate();

		if (result > 0)
			return true;
		return false;
	}

	@Override
	public boolean updateEmployee(Employee emp) throws SQLException {

		PreparedStatement stm;
		stm = con.prepareStatement("UPDATE `siemensdb`.`employee`\r\n" + "SET\r\n" + "`EmployeeName` = ?,\r\n"
				+ "`Salary` = ?\r\n" + "WHERE\r\n" + "EmployeeID = ?;");

		stm.setString(1, emp.getName());
		stm.setDouble(2, emp.getSalary());
		stm.setInt(3, emp.getId());

		int result = stm.executeUpdate();

		if (result < 0)
			return false;

		stm = con.prepareStatement("SELECT `AddressID` FROM `siemensdb`.`employee` WHERE `EmployeeID` = ?;");
		stm.setInt(1, emp.getId());

		ResultSet res = stm.executeQuery();

		if (res.next()) {
			emp.getEmployeeAddress().setAddressID(res.getInt("AddressID"));
		}

		Address empAddress = emp.getEmployeeAddress();

		PreparedStatement addStm = con.prepareStatement("UPDATE `siemensdb`.`address`\r\n" + "SET\r\n"
				+ "`address1` = ?,\r\n" + "`address2` = ?\r\n," + "`Street` = ?\r\n," + "`City` = ?\r\n,"
				+ "`Zipcode` = ?\r\n" + "WHERE\r\n" + "`AddressID` = ?;");

		addStm.setString(1, empAddress.getAddress1());
		addStm.setString(2, empAddress.getAddress2());
		addStm.setString(3, empAddress.getStreet());
		addStm.setString(4, empAddress.getCity());
		addStm.setInt(5, empAddress.getZipCode());
		addStm.setInt(6, empAddress.getAddressID());

		result = addStm.executeUpdate();

		if (result < 0)
			return false;

		return true;
	}

	@Override
	public Employee fetchEmployeeById(int empId) throws InvalidEmployeeIdException, SQLException {
		if (empId <= 0) {
			throw new InvalidEmployeeIdException("Employee ID cannot be <= 0!");
		}
		PreparedStatement stm = con.prepareStatement("SELECT * FROM `siemensdb`.`employee` WHERE `EmployeeID` = ?;");
		stm.setInt(1, empId);

		ResultSet empResult = stm.executeQuery();

		if (empResult.next()) {
			PreparedStatement addStm = con
					.prepareStatement("SELECT * FROM `siemensdb`.`address` WHERE `AddressID` = ?;");
			addStm.setInt(1, empResult.getInt("AddressID"));
			ResultSet addResult = addStm.executeQuery();
			if (addResult.next()) {
				return generateEmployee(empResult, addResult);
			}
		}

		return null;
	}

	@Override
	public ListIterator<Employee> fetchAllEmployees() throws SQLException {
		ArrayList<Employee> employeeList = new ArrayList<>();
		PreparedStatement empStm = con.prepareStatement("SELECT * FROM `siemensdb`.`employee`;");
		ResultSet empResult = empStm.executeQuery();
		while (empResult.next()) {
			PreparedStatement addStm = con
					.prepareStatement("SELECT * FROM `siemensdb`.`address` WHERE `AddressID` = ?;");
			addStm.setInt(1, empResult.getInt("AddressID"));

			ResultSet addResult = addStm.executeQuery();

			if (addResult.next()) {
				employeeList.add(generateEmployee(empResult, addResult));
			}
		}
		return employeeList.listIterator();
	}

	private Employee generateEmployee(ResultSet employeeSet, ResultSet addressSet) throws SQLException {
		Employee emp = new Employee(employeeSet.getInt("EmployeeID")).setName(employeeSet.getString("EmployeeName"))
				.setSalary(employeeSet.getDouble("Salary"))
				.setEmployeeAddress(new Address().setAddressID(addressSet.getInt("AddressID"))
						.setAddress1(addressSet.getString("address1")).setAddress2(addressSet.getString("address2"))
						.setStreet(addressSet.getString("Street")).setCity(addressSet.getString("City"))
						.setZipCode(addressSet.getInt("Zipcode")));
		return emp;
	}
}
