package employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import employee.elements.*;
import java.util.ArrayList;

public class EmployeeManagement {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

}
