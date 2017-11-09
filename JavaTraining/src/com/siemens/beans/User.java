package com.siemens.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name = "UserID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "UserName", nullable = false, length = 50)
	private String userName;

	@Column(name = "Password", nullable = false, length = 50)
	private String password;

	@Column(name = "Age", nullable = false)
	private int age;

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public int getAge() {
		return age;
	}

	public User setUserId(int userId) {
		this.userId = userId;
		return this;
	}

	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public User setPassword(String password) {
		this.password = password;
		return this;
	}

	public User setAge(int age) {
		this.age = age;
		return this;
	}
}
