package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the DEVELOPER database table.
 * 
 */
@Entity
@Table(name = "DEVELOPER")
@NamedQueries({
	@NamedQuery(name = "Developer.findAll", query = "SELECT d FROM Developer d"),
	@NamedQuery(name = "Developer.findAllNames", query = "SELECT d.name FROM Developer d"),
	@NamedQuery(name = "Developer.count", query = "SELECT COUNT(d) FROM Developer d"),
})
public class Developer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String name;

	public Developer() {
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}