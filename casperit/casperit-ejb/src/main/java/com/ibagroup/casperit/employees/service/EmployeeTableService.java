package com.ibagroup.casperit.employees.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.ibagroup.casperit.employees.database.dao.EmployeeTableDaoImpl;
import com.ibagroup.casperit.employees.database.dao.EmployeeTableSearchParams;
import com.ibagroup.casperit.employees.database.dto.EmployeeTable;

/**
 * 
 * @author IBA Group
 * @since 2019
 * 
 * An CRUD service for {@link EmployeeTable}
 *
 */

@Stateless
public class EmployeeTableService {
	
	@Inject
	EmployeeTableDaoImpl dao;
    
	public List<EmployeeTable> retrieveEmployeeTable(EmployeeTableSearchParams params) {
	    	return dao.retrieveEmployeeTableByParams(params);
	}
	
	public List<EmployeeTable> retrieveEmployeeTableByFSAParams(EmployeeTableSearchParams params) {
    	return dao.retrieveEmployeeTableByFSAParams(params);
	}
 
    public void deleteEmployeeTableById(Long id) {
    	dao.deleteEmployeeTableById(id);
    }
    
    public void createNewEmployeeTable(EmployeeTable entity) throws Exception {
    	dao.createNewEmployeeTable(entity);
    }
    
	
//    @PUT
//    @Path("/{id:[0-9][0-9]*}")
//    @Consumes("application/json")
//    public void update(@PathParam("id") Long id, Employee entity) {
//    	dao.update(id, entity);
//    }

}

