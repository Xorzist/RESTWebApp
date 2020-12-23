package egov.rphipps.RESTWebApp.Entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/*
@author rphipps
Created on : Dec 22, 2020
*/
@MappedSuperclass
public class AbstractEntity implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3118794165638772724L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
