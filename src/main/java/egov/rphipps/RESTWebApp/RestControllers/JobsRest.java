package egov.rphipps.RESTWebApp.RestControllers;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
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

@Path("jobs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JobsRest {

	@Inject
	JobsService jobsService;
	@Inject
	EmployeeService EmployeeService;

	@Path("edit/employee/{eid}/job/{jid}")
	@PUT
	public Response editEmployeeJob(@PathParam("eid") int empid,
			@PathParam("jid")int jobid) {
		Employee foundemployee = EmployeeService.findByID(empid);
		Jobs job = jobsService.findByID(jobid);
		foundemployee.setJob(job);
		EmployeeService.updateEmployee(foundemployee);
		return Response.ok(foundemployee).build();

	}
	
	@Path("new")
	@POST
	public Response createJob(Jobs job){
		
		return Response.ok(jobsService.createJob(job)).status(Status.CREATED).build();
		
	       
	    }

	@Path("all")
	@GET
	public Response getAllJobs() {
		return Response.ok(jobsService.getAllJobs()).status(Status.OK).build();
	}
	
	 @Path("{id}") 
	 @GET 
	 public Response getJobById(@PathParam("id") int id){
		 return  Response.ok(jobsService.findByID(id)).status(Status.OK).build();
	 }

}
