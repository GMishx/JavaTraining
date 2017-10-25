package com.siemens.collections.test;

import java.util.TreeSet;
import java.util.Set;
import com.siemens.beans.employee.*;
import java.util.Comparator;

public class TreeSetExample {

	public static void main(String[] args) {
		Set<Employee> employeeSet = new TreeSet<Employee>(new Comparator<Employee>() {

			@Override
			public int compare(Employee arg0, Employee arg1) {
				return (int) (arg0.getSalary() - arg1.getSalary());
			}

		});
		employeeSet.add(new Employee(1).setSalary(250.00).setName("A"));
		employeeSet.add(new Employee(2).setSalary(354.5).setName("B"));
		employeeSet.add(new Employee(1).setSalary(8972.36).setName("A"));
		employeeSet.add(new Employee(3).setSalary(123.36).setName("C"));
		employeeSet.add(new Employee(5).setSalary(3752.36).setName("E"));
		employeeSet.add(new Employee(1).setSalary(459.36).setName("A"));
		employeeSet.add(new Employee(8).setSalary(284.36).setName("H"));
		employeeSet.add(new Employee(6).setSalary(985.36).setName("F"));
		employeeSet.add(new Employee(4).setSalary(234.36).setName("D"));
		employeeSet.add(new Employee(3).setSalary(267.36).setName("C"));
		for (Employee employee : employeeSet) {
			System.out.println(employee);
		}
	}

}
