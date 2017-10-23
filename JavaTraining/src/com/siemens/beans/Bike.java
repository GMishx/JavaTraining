package com.siemens.beans;

public class Bike extends Vehicle {

	@Override
	public void drive() {
		System.out.println("Driving a bike: " + this.getvName());
	}

}
