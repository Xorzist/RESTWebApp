package egov.rphipps.RESTWebApp.RestControllers;

import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import egov.rphipps.RESTWebApp.Entity.Employee;
import egov.rphipps.RESTWebApp.Entity.Jobs;
import egov.rphipps.RESTWebApp.Service.EmployeeService;
import egov.rphipps.RESTWebApp.Service.JobsService;


/*
@author rphipps
Created on : Dec 22, 2020
*/

@Path("employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeRest {
	
	@Inject
	EmployeeService employeeService;
	@Inject
	JobsService jobsService;
	
	
	
	@Path("new")
	@POST
	public Response createEmployee(Employee employee){
			employeeService.createEmployee(employee);
	       return Response.ok(employee).status(Status.CREATED).build();
	      
	       
	    }
	
	 @Path("all") 
	 @GET 
	 public Response getAllEmployees(){
		 return Response.ok(employeeService.getAllEmployees()).build();
	 }
	 
	 @Path("{id}") 
	 @GET 
	 public Response getEmployeeById(@PathParam("id") int id){
		 return  Response.ok(employeeService.findByID(id)).build();
	 }
	 

	 @Path("ping")
    @GET
    public String ping() {
        return " Jakarta EE with MicroProfile 2+!";
    }

}
