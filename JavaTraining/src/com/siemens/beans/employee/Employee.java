package com.siemens.beans.employee;

public class Employee implements Comparable<Employee>, java.util.Comparator<Employee>, java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -200752679115823038L;
	
	private String name;
	private int id;
	private double salary;
	private Address employeeAddress;

	public Employee(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public Employee setId(int id) {
		this.id = id;
		return this;
	}

	public String getName() {
		return name;
	}

	public Employee setName(String name) {
		this.name = name;
		return this;
	}

	public double getSalary() {
		return salary;
	}

	public Employee setSalary(double salary) {
		this.salary = salary;
		return this;
	}

	public Address getEmployeeAddress() {
		return employeeAddress;
	}

	public Employee setEmployeeAddress(Address employeeAddress) {
		this.employeeAddress = employeeAddress;
		return this;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: " + this.getId());
		sb.append(", Name: " + this.getName());
		sb.append(", Salary: " + this.getSalary());
		sb.append(", " + this.employeeAddress);
		return sb.toString();
	}

	@Override
	public int hashCode() {
		/*final int prime = 31;
		int result = 1;
		result = prime * result + ((employeeAddress == null) ? 0 : employeeAddress.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;*/
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Employee arg0) {
		return this.id - arg0.id;
	}

	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.compareTo(arg1);
	}
}
