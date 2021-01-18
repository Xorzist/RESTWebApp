package egov.rphipps.RESTWebApp.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import egov.rphipps.RESTWebApp.EntityManagerProducer;
import egov.rphipps.RESTWebApp.Entity.Employee;

/*
@author rphipps
Created on : Dec 22, 2020

Class to define operations that interact with the entityManager bean to perform transactions for Job objects
*/
@Stateless
public class EmployeeService {

	/*
	 * Bean injected from the defined provider of @see EntityManagerProducer class.
	 */
	@Inject
	EntityManager entityManager;

	/*
	 * Method to trigger the entity manager to run the JPQL named query which will
	 * return a list of all the employees
	 */
	public List<Employee> getAllEmployees() {
		return entityManager.createNamedQuery(Employee.FIND_ALL_USERS, Employee.class).getResultList();

	}

	/*
	 * Method to trigger the entity manager to persist/save the job object into the
	 * persistence context and Database
	 */
	public Employee createEmployee(Employee employee) {
		entityManager.persist(employee);
		return employee;

	}

	/*
	 * Method to trigger the entity manager to find the specific entity by its ID
	 */
	public Employee findByID(int id) {
		return entityManager.find(Employee.class, id);

	}

	/*
	 * Method to trigger the entity manager to update the specified entity
	 */
	public Employee updateEmployee(Employee updatedEmployee) {
		entityManager.merge(updatedEmployee);
		return updatedEmployee;

	}

	/*
	 * Method to trigger the entity manager to delete a specified entity by its ID
	 */
	public List<Employee> deleteEmployee(int id) {
		Employee employeetoDelete = findByID(id);
		entityManager.remove(employeetoDelete);
		return getAllEmployees();
	}

}
