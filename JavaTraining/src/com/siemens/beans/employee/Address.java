package com.siemens.beans.employee;

public class Address {
	private int addressID;
	private String address1;
	private String address2;
	private String Street;
	private String City;
	private int zipCode;

	public int getAddressID() {
		return addressID;
	}

	public void setAddressID(int addressID) {
		this.addressID = addressID;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getStreet() {
		return Street;
	}

	public void setStreet(String street) {
		Street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [addressID=");
		builder.append(addressID);
		builder.append(", ");
		if ((address1 != null) && (!address1.isEmpty())) {
			builder.append("address1=");
			builder.append(address1);
			builder.append(", ");
		}
		if ((address2 != null) && (!address2.isEmpty())) {
			builder.append("address2=");
			builder.append(address2);
			builder.append(", ");
		}
		if ((Street != null) && (!Street.isEmpty())) {
			builder.append("Street=");
			builder.append(Street);
			builder.append(", ");
		}
		if ((City != null) && (!City.isEmpty())) {
			builder.append("City=");
			builder.append(City);
			builder.append(", ");
		}
		builder.append("zipCode=");
		builder.append(zipCode);
		builder.append("]");
		return builder.toString();
	}

}
