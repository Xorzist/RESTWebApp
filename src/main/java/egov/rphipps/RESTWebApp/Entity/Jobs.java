package egov.rphipps.RESTWebApp.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
@author rphipps
Created on : Dec 22, 2020

 * Entity model for the Job table
 */
@Entity
@NamedQuery(name = Jobs.FIND_ALL_JOBS, query = "select j from Jobs j order by j.salary ")
public class Jobs extends AbstractEntity {
	
	@NotBlank(message = "Title field cannot be left empty")
	private String title;
	@NotBlank(message = "Position field cannot be left empty")
	private String position;
	@NotNull(message = "Salary field cannot be left empty")
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
