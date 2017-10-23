package com.siemens.beans;

public abstract class Vehicle {
	private int vID;
	private String vName;
	private double cost;

	public int getvID() {
		return vID;
	}

	public void setvID(int vID) {
		this.vID = vID;
	}

	public String getvName() {
		return vName;
	}

	public void setvName(String vName) {
		this.vName = vName;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public abstract void drive();
}
