package JobTests;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import egov.rphipps.RESTWebApp.Entity.Jobs;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
@author rphipps
Created on : Dec 24, 2020

Tests Core Dependencies :
JUnit
Mockito
Hamcrest
RestAssured

*/

class JobsRestTest {
	private RequestSpecification given = RestAssured.given();
	private Response response;
	static private Jobs jobs = mock(Jobs.class);
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * Set up method to prepare the base URL, the port and Mock methods of the
	 *  Jobs class to prepare it with test values
	 * 
	 */
	@BeforeAll
	public static void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		when(jobs.getTitle()).thenReturn("Programmer", "Project Manager");
		when(jobs.getPosition()).thenReturn("mid", "senior");
		when(jobs.getSalary()).thenReturn(200, 500);
	}

	/*
	 * Method to generate a HashMap object to be used as the JSON object for creating 
	 * a Job
	 */
	private Map<String, Object> createPayLoad() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("title", jobs.getTitle());
		payload.put("position", jobs.getPosition());
		payload.put("salary", jobs.getSalary());
		return payload;
	}
	
	/*
	 * Test to create a new employee by utilizing the exposed REST end point
	 */
	@Test
	void testCreateJob() {
		// Store the HTTPS GET response to be used to extract details for validation
		response = given.contentType(ContentType.JSON).body(createPayLoad()).post("/RESTWebApp/api/v1/jobs/new");
		//Log response body of the request given at the Info log level
		logger.info("Response Body for Create Job --> {}", response.body().asString());
		response
		.then()
		.statusCode(201)
		.body("title", equalTo("Programmer"));
		
		// Store the HTTPS GET response to be used to extract details for validation
		response = given.contentType(ContentType.JSON).body(createPayLoad()).post("/RESTWebApp/api/v1/jobs/new");
		//Log response body of the request given at the Info log level
		logger.info("Response Body for Create Job --> {}", response.body().asString());
		response
		.then()
		.statusCode(201)
		.body("title", equalTo("Project Manager"));
		
	}

	/*
	 * Test to create add a job to an employee's description by utilizing the exposed REST end point
	 */
	@Test
	void testEditEmployeeJob() {
		int jobid = 2;
		int employeeID=1;
		response = given.contentType(ContentType.JSON).put("/RESTWebApp/api/v1/jobs/edit/employee/"+employeeID+
				"/job/"+jobid);
		logger.info("Response Body for Edit Employee Job --> {}", response.body().asString());
		response
		.then()
		.statusCode(200)
		.body("id", equalTo(employeeID));
	
	}

	/*
	 * Test to retrieve all jobs by utilizing the exposed REST end point
	 */
	@Test
	void testGetAllJobs() {
		// Store the HTTPS GET response to be used to extract details for validation
		response = RestAssured.get("/RESTWebApp/api/v1/jobs/all");
		assertThat(response.getStatusCode(), is(200));
		
	}
	
	/*
	 * Test to retrieve an employee by Id by utilizing the exposed REST end point
	 */
	@Test
	void testGetJobById() {
		int jobId = 2;
		// Store the HTTPS GET response to be used to extract details for validation
		response = given.contentType(ContentType.JSON).when().get("/RESTWebApp/api/v1/jobs/" + jobId);
		logger.info("Response Body for Get Employee by ID --> {}", response.body().asString());
		response
		.then()
		.statusCode(200).body("id", equalTo(jobId));
		
	}

}
