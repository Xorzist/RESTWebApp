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
*/
@Stateless
public class EmployeeService {
	
	@Inject
	EntityManager entityManager;
	
	public List<Employee> getAllEmployees() {
		return entityManager.
				createNamedQuery(Employee.FIND_ALL_USERS, Employee.class).getResultList();
		
	}
	public Employee createEmployee(Employee employee) {
		 entityManager.persist(employee);
		 return employee;
		 
	}
	
	public Employee findByID(int id) {
		return entityManager.find(Employee.class, id);
		
	}
	
	public Employee updateEmployee(Employee employee) {
		 entityManager.merge(employee);
		 return employee;
		
	}
	
	
	
	

}
