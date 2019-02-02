package com.ibagroup.casperit.meetingroom.database.dao;

public class MeetingRoomReservationSearchParams {

	private Long id;
	
	private String name;
	
	private String floor;
	
	private String complectation;
	
	private String capacity;
	
	private String startDate;
	
	private String endDate;
	
	private String firstName;
	
	private String lastName;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFloor() {
		return floor;
	}

	public String getComplectation() {
		return complectation;
	}

	public String getCapacity() {
		return capacity;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public void setComplectation(String complectation) {
		this.complectation = complectation;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
