package legacydev.rphipps.RESTWebApp.RestControllers;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import legacydev.rphipps.RESTWebApp.Entity.Employee;
import legacydev.rphipps.RESTWebApp.Service.EmployeeService;
import legacydev.rphipps.RESTWebApp.Service.JobsService;

/*
@author rphipps
Created on : Dec 22, 2020

This class defines the pattern,requests and logic of the REST end points that will be exposed from our application to 
handle requests made to the employee table.
*/

@Path("employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeRest {
	
	/*
	 * Beans to be handled by the CDI container to perform transactions 
	 */
	@Inject
	EmployeeService employeeService;
	@Inject
	JobsService jobsService;

	/*
	 * Method to handle a request to create an employee record 
	 */
	@Path("new")
	@POST
	public Response createEmployee(Employee employee) {
		employeeService.createEmployee(employee);
		return Response.ok(employee).status(Status.CREATED).build();

	}
	
	/*
	 * Method to handle a request to retrieve all employee records 
	 */
	@Path("all")
	@GET
	public Response getAllEmployees() {
		return Response.ok(employeeService.getAllEmployees()).build();
	}

	/*
	 * Method to handle a request to the retrieval of an employee record by using its ID
	 */
	@Path("{id}")
	@GET
	public Response getEmployeeById(@PathParam("id") int id) {
		return Response.ok(employeeService.findByID(id)).build();
	}
	/*
	 * Method to handle a request to delete an employee record  by using its ID
	 */
	@Path("{id}")
	@DELETE
	public Response deleteEmployeeById(@PathParam("id") int id) {
		return Response.ok(employeeService.deleteEmployee(id)).build();
	}
	/*
	 * Method to handle a request to update an employee record by using its ID
	 */
	@Path("{id}")
	@PUT
	public Response updateEmployeeByID(@PathParam("id") int id, Employee employee) {
		Employee employeeToUpdate = employeeService.findByID(id);
		employeeToUpdate.setFirstName(employee.getFirstName());
		employeeToUpdate.setLastName(employee.getLastName());
		return Response.ok(employeeService.updateEmployee(employeeToUpdate)).build();
	}

}
