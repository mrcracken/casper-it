package com.ibagroup.casperit.employee.web.rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibagroup.casperit.employees.database.dao.EmployeeSearchParams;
import com.ibagroup.casperit.employees.database.dto.Employee;
import com.ibagroup.casperit.employees.service.EmployeeService;

/**
 * JAX-RS CRUD for {@link Employee}
 * <p/>
 * This class produces a RESTful service to read/write the contents of the members table.
 */
@Path("/employees")
@RequestScoped
public class EmployeeEndpoint {

	@Inject
    private EmployeeService service;

	/*
	 * Return all employees
	 */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> listAllEmps() {
    	EmployeeSearchParams params = new EmployeeSearchParams();
        return service.retrieveEmployee(params);
    }
    
    /*
	 * Return employee by ID
	 */
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public List<Employee> listAllEmpsId(@PathParam("id") Long id) {
    	EmployeeSearchParams params = new EmployeeSearchParams();
    	params.setId(id);
        return service.retrieveEmployee(params);
    }

    /*
	 * Delete employee by ID
	 */
    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public void deleteById(@PathParam("id") Long id) {
    	service.deleteEmployeeById(id);
    }
    
    /*
	 * Create a new employee
	 */
    @POST
    @Consumes("application/json")
    public void createNewEmp(Employee entity) throws Exception {
    	service.createNewEmployee(entity);
    }
	
}
