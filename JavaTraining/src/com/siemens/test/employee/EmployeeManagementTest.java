package com.siemens.test.employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ListIterator;

import com.siemens.beans.employee.Address;
import com.siemens.beans.employee.Employee;
import com.siemens.exceptions.employee.InvalidEmployeeIdException;
import com.siemens.service.employee.EmployeeManagement;
import com.siemens.service.employee.EmployeeManagementImpl;

public class EmployeeManagementTest {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
		try {
			System.out.print("Enter DB userName: ");
			String user = br.readLine();
			System.out.print("Enter DB password: ");
			String password = br.readLine();
			//char[] pass = System.console().readPassword();
			//String password = new String(pass);
			EmployeeManagement employeeManagement = new EmployeeManagementImpl(user, password);
			System.out.println();
			int choice = 0;
			do {
				printMenu();
				choice = Integer.parseInt(br.readLine());
				switch (choice) {
				case 1: {
					Employee emp = getNextEmployee();
					int eID = employeeManagement.insertEmployee(emp);
					if (eID > 0) {
						System.out.println("Employee with ID: " + eID + " inserted successfully!");
					} else {
						System.out.println("Unable to insert the employee!");
					}
				}
					break;

				case 2: {
					System.out.print("Enter the employee id to be updated: ");
					int eId = Integer.parseInt(br.readLine());
					System.out.println("Enter the new details: ");
					Employee emp = getNextEmployee();
					emp.setId(eId);
					boolean updated = employeeManagement.updateEmployee(emp);
					if (updated) {
						System.out.println("Updated successfully!");
					} else {
						System.out.println("Unable to update!");
					}
				}
					break;

				case 3: {
					System.out.print("Enter the id to be deleted: ");
					int eId = Integer.parseInt(br.readLine());
					boolean deleted = employeeManagement.deleteEmployee(eId);
					if (deleted) {
						System.out.println("Deleted successfully!");
					} else {
						System.out.println("Deleted to update!");
					}
				}
					break;

				case 4: {
					ListIterator<Employee> li = employeeManagement.fetchAllEmployees();
					while (li.hasNext()) {
						System.out.println(li.next());
					}
				}
				}
			} while ((choice > 0) && (choice < 5));
		} catch (NumberFormatException | IOException | ClassNotFoundException | SQLException
				| InvalidEmployeeIdException e) {
			e.printStackTrace();
		}

	}

	private static Employee getNextEmployee() throws NumberFormatException, IOException {
		Employee emp = new Employee(0);
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

	private static void printMenu() {
		System.out.println();
		System.out.println("===========================");
		System.out.println("1. Add employee");
		System.out.println("2. Update employee");
		System.out.println("3. Delete employee");
		System.out.println("4. Fetch all employees");
		System.out.println("5. Exit");
		System.out.print("Enter your choice: ");
	}

}
