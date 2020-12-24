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
*/
@Stateless
public class JobsService {
	
	@Inject
	EntityManager entityManager;
	
	public List<Jobs> getAllJobs() {
		return entityManager.
				createNamedQuery(Jobs.FIND_ALL_JOBS,Jobs.class).getResultList();
		
	}
	public Jobs createJob(Jobs job) {
		 entityManager.persist(job);
		 return job;
		 
	}
	
	public Jobs findByID(int id) {
		return entityManager.find(Jobs.class, id);
		
	}
	
	
	

}
