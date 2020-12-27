package EmployeeTests;
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

import egov.rphipps.RESTWebApp.Entity.Employee;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/*
@author rphipps
Created on : Dec 23, 2020

Tests Core Dependencies :
JUnit
Mockito
Hamcrest
RestAssured
*/

class EmployeeRestTest {
	
	private RequestSpecification given = RestAssured.given();
	private Response response;
	static private Employee employee = mock(Employee.class);
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	/*
	 * Set up method to prepare the base URL, the port and Mock methods of the
	 *  Employee class to prepare it with test values
	 * 
	 */
	@BeforeAll
	public static void setUp() {
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = 8080;
		when(employee.getFirstName()).thenReturn("Cathy","Jus");
		when(employee.getLastName()).thenReturn("May","Values");
	}

	/*
	 * Method to generate a HashMap object to be used as the JSON object for creating an 
	 * employee 
	 */
	private Map<String, Object> createPayLoad() {
		Map<String, Object> payload = new HashMap<>();
		payload.put("firstName", employee.getFirstName());
		payload.put("lastName", employee.getLastName());
		return payload;
	}

	/*
	 * Test to create a new employee by utilizing the exposed REST end point
	 */
	@Test
	void testCreateEmployee() {
		
		// Store the HTTPS GET response to be used to extract details for validation
		response = given.contentType(ContentType.JSON).body(createPayLoad()).post("/RESTWebApp/api/v1/employees/new");
		//Log response body of the request given at the Info log level
		logger.info("Response Body for Create Employee --> {}", response.body().asString());
		response
		.then()
		.statusCode(201)
		.body("firstName", equalTo("Cathy"));
		
		// Store the HTTPS GET response to be used to extract details for validation
		response = given.contentType(ContentType.JSON).body(createPayLoad()).post("/RESTWebApp/api/v1/employees/new");
		//Log response body of the request given at the Info log level
		logger.info("Response Body for Create Employee -->  {}", response.body().asString());
		response
		.then()
		.statusCode(201)
		.body("firstName", equalTo("Jus"));

	}

	/*
	 * Test to retrieve all employees by utilizing the exposed REST end point
	 */
	@Test
	void testGetAllEmployees() {
		// Store the HTTPS GET response to be used to extract details for validation
		response = RestAssured.get("/RESTWebApp/api/v1/employees/all");
		assertThat(response.getStatusCode(), is(200));

	}

	/*
	 * Test to retrieve an employee by Id by utilizing the exposed REST end point
	 */
	@Test
	void testGetEmployeeById() {
		int employeeId = 1;
		// Store the HTTPS GET response to be used to extract details for validation
		response = given.contentType(ContentType.JSON).when().get("/RESTWebApp/api/v1/employees/" + employeeId);
		//Log response body of the request given at the Info log level
		logger.info("Response Body for Get Employee by ID --> {}", response.body().asString());
		response
		.then()
		.statusCode(200).body("id", equalTo(employeeId));
	}

}
