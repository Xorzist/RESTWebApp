package egov.rphipps.RESTWebApp.RestControllers;

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

import egov.rphipps.RESTWebApp.Entity.Employee;
import egov.rphipps.RESTWebApp.Entity.Jobs;
import egov.rphipps.RESTWebApp.Service.EmployeeService;
import egov.rphipps.RESTWebApp.Service.JobsService;

/*
@author rphipps
Created on : Dec 22, 2020

This class defines the pattern,requests and logic of the REST end points that will be exposed from our application to 
handle requests made to the jobs table.
*/

@Path("jobs")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class JobsRest {

	/*
	 * Beans to be handled by the CDI container to perform transactions 
	 */
	@Inject
	JobsService jobsService;
	@Inject
	EmployeeService EmployeeService;

	
	/*
	 * Method to handle a request to create an employee record 
	 */
	@Path("new")
	@POST
	public Response createJob(Jobs job){
		
		return Response.ok(jobsService.createJob(job)).status(Status.CREATED).build();
		
	       
	    }
	/*
	 * Method to handle a request to retrieve all job records 
	 */
	@Path("all")
	@GET
	public Response getAllJobs() {
		return Response.ok(jobsService.getAllJobs()).status(Status.OK).build();
	}
	/*
	 * Method to handle a request to the retrieval of a job record by using its ID
	 */
	 @Path("{id}") 
	 @GET 
	 public Response getJobById(@PathParam("id") int id){
		 return  Response.ok(jobsService.findByID(id)).status(Status.OK).build();
	 }
	 /*
		 * Method to handle a request to delete a job record  by using its ID
		 */
	 @Path("{id}") 
	 @DELETE 
	 public Response deletejobById(@PathParam("id") int id){
		 jobsService.deleteJob(id);
		 return  Response.ok().build();
	 }
	 /*
		 * Method to handle a request to update a job record by using its ID
		 */
	 @Path("{id}") 
	 @PUT 
	 public Response updatejobById(@PathParam("id") int id,Jobs job ){
		 Jobs jobtoUpdate = jobsService.findByID(id);
		 jobtoUpdate.setPosition(job.getPosition());
		 jobtoUpdate.setTitle(job.getTitle());
		 jobtoUpdate.setSalary(job.getSalary());
		return  Response.ok(jobsService.updateJob(jobtoUpdate)).build();
	 }
	 
	 /*
	  * Method to handle a request to update the job details of a specific user by 
	  * providing the user's id and job's id
	  */
	 @Path("edit/employee/{eid}/job/{jid}")
		@PUT
		public Response editEmployeeJob(@PathParam("eid") int empid,
				@PathParam("jid")int jobid) {
			Employee foundemployee = EmployeeService.findByID(empid);
			Jobs job = jobsService.findByID(jobid);
			foundemployee.setJob(job);
			jobsService.updateEmployeeJob(foundemployee);
			return Response.ok(foundemployee).build();

		}

}
