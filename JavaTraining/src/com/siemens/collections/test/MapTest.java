package com.siemens.collections.test;

import java.util.HashMap;
import java.util.Map;
import com.siemens.beans.employee.*;

public class MapTest {

	public static void main(String[] args) {
		Map<Integer, Employee> employeeMap = new HashMap<>();

		employeeMap.put(1, new Employee(1).setName("A").setSalary(100));
		employeeMap.put(2, new Employee(2).setName("B").setSalary(200));
		employeeMap.put(3, new Employee(3).setName("C").setSalary(300));
		employeeMap.put(4, new Employee(4).setName("D").setSalary(400));
		employeeMap.put(4, new Employee(4).setName("D").setSalary(400));
		employeeMap.put(5, new Employee(5).setName("E").setSalary(500));

		System.out.println("Size: " + employeeMap.size());

		for (int key : employeeMap.keySet()) {
			System.out.println("employeeMap[" + key + "] = " + employeeMap.get(key));
		}
	}

}
