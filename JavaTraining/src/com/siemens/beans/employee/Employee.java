package com.siemens.beans.employee;

public class Employee {
	private String name;
	private final int id;
	private double salary;
	private Address employeeAddress;

	public Employee(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(Address employeeAddress) {
		this.employeeAddress = employeeAddress;
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
}
