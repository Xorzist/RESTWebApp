package egov.rphipps.RESTWebApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotBlank;

/*
@author rphipps
Created on : Dec 22, 2020
*/
@Entity
@NamedQuery(name = Jobs.FIND_ALL_JOBS, query = "select j from Jobs j order by j.salary ")
public class Jobs extends AbstractEntity {
	
	@NotBlank
	private String title;
	@NotBlank
	private String position;
	private int salary;
	public static final String FIND_ALL_JOBS = "Jobs.findAllJobs";
	

	@Override
	public String toString() {
		return "Jobs [title=" + title + ", position=" + position + ", salary=" + salary + "]";
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	

}
