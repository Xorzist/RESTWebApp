package egov.rphipps.RESTWebApp.Entity;

import java.sql.Date;
import java.time.LocalDate;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;


/*
@author rphipps
Created on : Dec 22, 2020
*/
@Entity
@NamedQuery(name = Employee.FIND_ALL_USERS, query = "select e from Employee e order by e.lastName")
public class Employee extends AbstractEntity {

	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@JsonbDateFormat(value = "yyyy-MM-dd")
	private LocalDate dateEmployed;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "JobId")
	private Jobs job;

	public static final String FIND_ALL_USERS = "Employee.findAllUsers";
	


	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", dateEmployed=" + dateEmployed
				+ ", job=" + job + "]";
	}

	@PrePersist
	public void setDateEmployedToNow() {
		setDateEmployed(LocalDate.now());
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDateEmployed() {
		return dateEmployed;
	}

	public void setDateEmployed(LocalDate string) {
		this.dateEmployed = string;
	}

	public Jobs getJob() {
		return job;
	}

	public void setJob(Jobs job) {
		this.job = job;
	}

}
