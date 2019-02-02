package com.ibagroup.casperit.employees.database.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
public class EmployeeTable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue
	private Long id;
	
	@NotNull
	@Column(name = "code")
	private String code;
	
	@NotNull
	@Column(name = "floor")
	private String floor;
	
	@NotNull
	@Column(name = "space")
	private String space;
	
	@NotNull
	@Column(name = "address")
	private String address;
	
	@ManyToOne
	private Employee employee;

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

	public Employee getEmployee() {
		return employee;
	}
	
	public String getAddress() {
		return address;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((space == null) ? 0 : space.hashCode());
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
		EmployeeTable other = (EmployeeTable) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
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
		if (space == null) {
			if (other.space != null)
				return false;
		} else if (!space.equals(other.space))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EmployeeTable [id=" + id + ", code=" + code + ", floor=" + floor + ", space=" + space + ", address="
				+ address + ", employee=" + employee + "]";
	}
	
}
