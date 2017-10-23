package com.siemens.beans;

public class Car extends Vehicle {

	@Override
	public void drive() {
		System.out.println("Driving a car: " + this.getvName());
	}

}
