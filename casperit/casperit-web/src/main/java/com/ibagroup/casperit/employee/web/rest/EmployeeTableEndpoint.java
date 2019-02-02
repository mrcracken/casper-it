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

import com.ibagroup.casperit.employees.database.dao.EmployeeTableSearchParams;
import com.ibagroup.casperit.employees.database.dto.EmployeeTable;
import com.ibagroup.casperit.employees.service.EmployeeTableService;

/**
 * JAX-RS CRUD for {@link EmployeeTable}
 * <p/>
 * This class produces a RESTful service to read/write the contents of the members table.
 */
@Path("/tables")
@RequestScoped
public class EmployeeTableEndpoint {

	@Inject
    private EmployeeTableService service;

	/*
	 * Return all employee tables
	 */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<EmployeeTable> retrieveAllEmployees() {
    	EmployeeTableSearchParams params = new EmployeeTableSearchParams();
        return service.retrieveEmployeeTable(params);
    }
    
    /*
	 * Return employee table by ID
	 */
    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public List<EmployeeTable> retrieveEmployeeTableById(@PathParam("id") Long id) {
    	EmployeeTableSearchParams params = new EmployeeTableSearchParams();
    	params.setId(id);
        return service.retrieveEmployeeTable(params);
    }

    /*
   	 * Return employee table by floor, space and address
   	 */
    @GET
    @Path("/{floor}/{space}/{address}")
    @Produces("application/json")
    public List<EmployeeTable> findByFloorSpaceAddress(@PathParam("floor") String floor,
    												   @PathParam("space") String space,
    												   @PathParam("address") String address) {
    	EmployeeTableSearchParams params = new EmployeeTableSearchParams();
    	params.setFloor(floor);
    	params.setSpace(space);
    	params.setAddress(address);
    	return service.retrieveEmployeeTableByFSAParams(params);
    }

    
    /*
	 * Delete employee table by ID
	 */
    @DELETE
    @Path("/{id:[0-9][0-9]*}")
    public void deleteEmployeeTableById(@PathParam("id") Long id) {
    	service.deleteEmployeeTableById(id);
    }
    
    /*
	 * Create a new employee table
	 */
    @POST
    @Consumes("application/json")
    public void createNewEmployeeTable(EmployeeTable entity) throws Exception {
    	service.createNewEmployeeTable(entity);
    }
	
}
