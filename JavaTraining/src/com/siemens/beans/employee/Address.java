package com.siemens.beans.employee;

public class Address implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2745048529184453175L;
	
	private int addressID;
	private String address1;
	private String address2;
	private String Street;
	private String City;
	private int zipCode;

	public int getAddressID() {
		return addressID;
	}

	public Address setAddressID(int addressID) {
		this.addressID = addressID;
		return this;
	}

	public String getAddress1() {
		return address1;
	}

	public Address setAddress1(String address1) {
		this.address1 = address1;
		return this;
	}

	public String getAddress2() {
		return address2;
	}

	public Address setAddress2(String address2) {
		this.address2 = address2;
		return this;
	}

	public String getStreet() {
		return Street;
	}

	public Address setStreet(String street) {
		Street = street;
		return this;
	}

	public String getCity() {
		return City;
	}

	public Address setCity(String city) {
		City = city;
		return this;
	}

	public int getZipCode() {
		return zipCode;
	}

	public Address setZipCode(int zipCode) {
		this.zipCode = zipCode;
		return this;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((City == null) ? 0 : City.hashCode());
		result = prime * result + ((Street == null) ? 0 : Street.hashCode());
		result = prime * result + ((address1 == null) ? 0 : address1.hashCode());
		result = prime * result + ((address2 == null) ? 0 : address2.hashCode());
		result = prime * result + addressID;
		result = prime * result + zipCode;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Address)) {
			return false;
		}
		Address other = (Address) obj;
		if (City == null) {
			if (other.City != null) {
				return false;
			}
		} else if (!City.equals(other.City)) {
			return false;
		}
		if (Street == null) {
			if (other.Street != null) {
				return false;
			}
		} else if (!Street.equals(other.Street)) {
			return false;
		}
		if (address1 == null) {
			if (other.address1 != null) {
				return false;
			}
		} else if (!address1.equals(other.address1)) {
			return false;
		}
		if (address2 == null) {
			if (other.address2 != null) {
				return false;
			}
		} else if (!address2.equals(other.address2)) {
			return false;
		}
		if (addressID != other.addressID) {
			return false;
		}
		if (zipCode != other.zipCode) {
			return false;
		}
		return true;
	}

}
