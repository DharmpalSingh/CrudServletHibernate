package com.org.pojo;

//import javax.persistence.Entity;

public class Employee {
	
	
	private String name;
	private String password;
	private String email;
	private String country;
	
	public Employee(String name, String password, String email, String country) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.country = country;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	

}
