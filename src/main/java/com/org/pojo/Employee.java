package com.org.pojo;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import javax.persistence.Entity;

@Entity
@Table(name="emp500")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String password;
	private String email;
	private String country;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	

	public Employee() {
		super();
	}

	public Employee( String name, String password, String email, String country) {
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
