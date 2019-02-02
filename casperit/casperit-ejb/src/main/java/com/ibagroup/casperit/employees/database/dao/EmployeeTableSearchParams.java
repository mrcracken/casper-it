package com.ibagroup.casperit.employees.database.dao;

/**
 * 
 * @author IBA Group
 * @since 2019
 *
 */
public class EmployeeTableSearchParams {

	private Long id;
	
	private String code;
	
	private String floor;
	
	private String space;
	
	private String firstName;
	
	private String lastName;
	
	private String specialization;
	
	private String phone;
	
	private String address;

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public String getFloor() {
		return floor;
	}

	public String getSpace() {
		return space;
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

	public String getAddress() {
		return address;
	}
	
	public void setCode(String code) {
		this.code = code;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public void setSpace(String space) {
		this.space = space;
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
	
	public void setAddress(String address) {
		this.address = address;
	}
	
}
