package com.ibagroup.casperit.employees.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ibagroup.casperit.employees.database.dao.EmployeeDaoImpl;
import com.ibagroup.casperit.employees.database.dao.EmployeeSearchParams;
import com.ibagroup.casperit.employees.database.dto.Employee;

/**
 * 
 * @author IBA Group
 * @since 2019
 * 
 * An CRUD service for {@link Employee}
 *
 */

@Stateless
public class EmployeeService {
	
	@Inject
	EmployeeDaoImpl dao;
    
	public List<Employee> retrieveEmployee(EmployeeSearchParams params) {
	    	return dao.retrieveEmployeeByParams(params);
	    }
 
    public void deleteEmployeeById(Long id) {
    	dao.deleteEmployeeById(id);
    }
    
    public void createNewEmployee(Employee entity) throws Exception {
    	dao.createNewEmployee(entity);
    }
    
	
//    @PUT
//    @Path("/{id:[0-9][0-9]*}")
//    @Consumes("application/json")
//    public void update(@PathParam("id") Long id, Employee entity) {
//    	dao.update(id, entity);
//    }

}

