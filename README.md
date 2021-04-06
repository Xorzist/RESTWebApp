
# JEE  Implementation of a REST Web Service :rocket:

**This is a JEE (Jakarta Enterprise Edition) based project. This project  utilizes the specifications from  JAX-RS (Jakarta RESTful Web Services), JPA (Java Persistence API),JTA(Java Transaction API) and CDI (Context Dependency Injection).**

**This project when successfully built and deployed unto a server will provide a RESTful Web service, capable of executing a set of CRUD(Create,Read,Update & Delete) operations. This service can be used as the back-end component for an Employee Management System**

---

**This RESTful Web service utilzes a simple persistence unit to simulate database storage. This service allows for :**
* Creation of an employee record
* Updating an employee's details
* Retrieving a specific employee's details
* Deletion of a specific employee record
* Creation of a job for use by employees 
* Updating job details
* Retrieving the details of a spceific job record
* Deletion of a job

---
* This project utilizes Maven as its build automation tool,thus it has a POM attached that details all the necessarry dependencies for this project. 
  - Therefore without utilizing an IDE the deployable archive for this project can be built by utilizing maven goals.

* This project comes packaged with the payara-micro jar for quick depoloyment to test the REST Service that has been packaged as a WAR(Web Application Archive). 

  - The command to utilize the payara micro jar is as follows :
  - java -jar p5.jar "location/to/file/RESTWebApp.war"
* If the aforementioned command has executed successfully, the list of available endpoints will be displayed in your terminal/console.

---

# Sequence of Execution :comet:
In order to get this project deployed and accessable ,the following sequence can be followed.

1. Clone the project to your local system.
2. Open your command line interface.
2. Navigate to folder that the project has been cloned to.

3. Run the following command to build the WAR file for the project :

```
 mvn clean install
```
4. Upon a successfull build you can then proceed to deploy the WAR file unto the payara-micro server by utilizing the following command :

```
 java -jar p5.jar "location/to/file/RESTWebApp.war"
```

5. Once the service has been successfully launched , I advise you to acess the following webpage http://localhost:8080/RESTWebApp/index.html.
  
# API Documentation :space_invader:
**Once the application has been deployed and the server is running you should visit  the following URL http://localhost:8080/RESTWebApp/index.html. This page provides documentation on how to utilize the API and adheres to OAS 3.0 *(Open API specificaton, previosuly Swagger)*.**

*The aforementioned page provides fully functional widgets that allow the execution of API calls that will provide you with realtime results and examples of how to utilise the service.*
