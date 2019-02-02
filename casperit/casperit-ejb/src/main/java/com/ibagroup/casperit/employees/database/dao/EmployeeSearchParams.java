package com.ibagroup.casperit.employees.database.dao;

public class EmployeeSearchParams {

	private Long id;
	
	private String firstName;

	private String lastName;
	
	private String specialization;
	
	private String phone;
	
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public String getPhone() {
		return phone;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
