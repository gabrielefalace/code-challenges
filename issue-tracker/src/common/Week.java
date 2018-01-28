package common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.Story;

public class Week implements Serializable {

	private static final long serialVersionUID = 1L;

	private int maxCapacity;
	
	private int remainingCapacity; // derived attribute

	private List<Story> stories;

	public Week(int maxCapacity) {
		this.stories = new ArrayList<Story>();
		this.maxCapacity = maxCapacity;
		this.remainingCapacity = maxCapacity;
	}

	public void addStory(Story story) {
		stories.add(story);
		remainingCapacity -= story.getEstimatedPoints();
	}

	public boolean canHold(Story story) {
		return story.getEstimatedPoints() <= remainingCapacity;
	}

	public boolean isFull() {
		return remainingCapacity == 0;
	}

	public int getRemainingCapacity() {
		return remainingCapacity;
	}

	public int getFilledCapacity(){
		return maxCapacity - remainingCapacity;
	}
	
	public int getMaxCapacity(){
		return maxCapacity;
	}
	
	public List<Story> getStories() {
		return stories;
	}

}
