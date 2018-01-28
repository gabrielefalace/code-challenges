package model;

import java.io.Serializable;
import javax.persistence.*;


import model.Issue;

/**
 * Entity implementation class for Entity: Story
 * 
 */
@Entity
@Table(name = "STORY")
@DiscriminatorValue("S")
@NamedQueries({
		@NamedQuery(name = "Story.findAll", query = "SELECT s FROM Story s"),
		@NamedQuery(name = "Story.opened", query = "SELECT s FROM Story s WHERE s.storyStatus != 'COMPLETED'") })
public class Story extends Issue implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "STORY_STATUS")
	private String storyStatus;


	@Column(name = "ESTIMATED_POINTS")
	private Long estimatedPoints;

	public String getStoryStatus() {
		return storyStatus;
	}

	public void setStoryStatus(String storyStatus) {
		this.storyStatus = storyStatus;
	}

	public Long getEstimatedPoints() {
		return estimatedPoints;
	}

	public void setEstimatedPoints(Long estimatedPoints) {
		this.estimatedPoints = estimatedPoints;
	}

}
