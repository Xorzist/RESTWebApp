package egov.rphipps.RESTWebApp.Service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import egov.rphipps.RESTWebApp.Entity.Employee;
import egov.rphipps.RESTWebApp.Entity.Jobs;

/*
@author rphipps
Created on : Dec 22, 2020

Class to define operations that interact with the entityManager bean to perform transactions for Job objects
*/
@Stateless
public class JobsService {

	/*
	 * Bean injected from the defined provider of @see EntityManagerProducer class.
	 */
	@Inject
	EntityManager entityManager;

	/*
	 * Method to trigger the entity manager to run the JPQL named query which will
	 * return a list of all the Jobs
	 */
	public List<Jobs> getAllJobs() {
		return entityManager.createNamedQuery(Jobs.FIND_ALL_JOBS, Jobs.class).getResultList();

	}

	/*
	 * Method to trigger the entity manager to persist/save the job object into the
	 * persistence context and Database
	 */
	public Jobs createJob(Jobs job) {
		entityManager.persist(job);
		return job;

	}

	/*
	 * Method to trigger the entity manager to find the specific entity by its ID
	 */
	public Jobs findByID(int id) {
		return entityManager.find(Jobs.class, id);

	}

	/*
	 * Method to trigger the entity manager to update the specified entity
	 */
	public Jobs updateJob(Jobs updatedJob) {
		entityManager.merge(updatedJob);
		return updatedJob;

	}

	/*
	 * Method to trigger the entity manager to delete a specified entity by its ID
	 */
	public void deleteJob(int id) {
		Jobs jobtoDelete = findByID(id);
		entityManager.remove(jobtoDelete);
	}

	/*
	 * Method to trigger the entity manager to update a specified entity
	 */
	public Employee updateEmployeeJob(Employee employee) {
		entityManager.merge(employee);
		return employee;

	}

}
