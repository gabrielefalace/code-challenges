package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Bug
 * 
 */
@Entity
@Table(name = "BUG")
@DiscriminatorValue("B")
@NamedQueries({
		@NamedQuery(name = "Bug.findAll", query = "SELECT b FROM Bug b"),
		@NamedQuery(name = "Bug.opened", query = "SELECT b FROM Bug b WHERE b.bugStatus != 'RESOLVED'") })
public class Bug extends Issue implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "PRIORITY")
	private String priority;

	@Column(name = "BUG_STATUS")
	private String bugStatus;

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getBugStatus() {
		return bugStatus;
	}

	public void setBugStatus(String bugStatus) {
		this.bugStatus = bugStatus;
	}

}
