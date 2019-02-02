package com.ibagroup.casperit.meetingroom.database.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author IBA Group
 * @since 2019
 *
 */

@Entity
@XmlRootElement
public class MeetingRoom implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
	private Long id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "floor")
	private Integer floor;
	
	@NotNull
	@Column(name = "capacity")
	private Integer capacity;
	
	@NotNull
	@Column(name = "complectation")
	private String complectation;

	@NotNull
	@Column(name = "address")
	private String address;
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getFloor() {
		return floor;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public String getComplectation() {
		return complectation;
	}

	public String getAddress() {
		return address;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public void setComplectation(String complectation) {
		this.complectation = complectation;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((capacity == null) ? 0 : capacity.hashCode());
		result = prime * result + ((complectation == null) ? 0 : complectation.hashCode());
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetingRoom other = (MeetingRoom) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (capacity == null) {
			if (other.capacity != null)
				return false;
		} else if (!capacity.equals(other.capacity))
			return false;
		if (complectation == null) {
			if (other.complectation != null)
				return false;
		} else if (!complectation.equals(other.complectation))
			return false;
		if (floor == null) {
			if (other.floor != null)
				return false;
		} else if (!floor.equals(other.floor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MeetingRoom [id=" + id + ", name=" + name + ", floor=" + floor + ", capacity=" + capacity
				+ ", complectation=" + complectation + ", address=" + address + "]";
	}

}
