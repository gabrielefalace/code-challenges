package services;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.Story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import common.Week;
import dao.DeveloperDAO;
import dao.IssueDAO;

@Service
public class PlannerService {
	
	public static final int POINTS_PER_DEVELOPER = 10;

	@Autowired
	private DeveloperDAO developerDAO;
	
	@Autowired
	private IssueDAO issueDAO;
	

	
	/**
	 * Double-scan greedy approach: O(N^2) complexity on N open stories
	 * @return
	 */
	public List<Week> getStoryPlan(){
		// retrieving all the open stories
		List<Story> openedStories = issueDAO.getOpenedStories();
		
		// sorting stories according to estimated points
		Collections.sort(openedStories, new Comparator<Story>() {
			@Override
			public int compare(Story story1, Story story2) {
				return (int) (story2.getEstimatedPoints() - story1.getEstimatedPoints());
			}
		});
		
		// preparing week data
		int developerCount = developerDAO.getDevelopersCount();
		int pointsPerWeek = developerCount * POINTS_PER_DEVELOPER;
		
		return computePlan(openedStories, pointsPerWeek);
	}
	
	
	/**
	 * Performs a double scan on the given story list, while adding stories to the plan, they get removed from the orginal list.
	 * @param openedStories the stories to put in the project plan
	 * @param pointsPerWeek the amount of points that can be done within one week
	 * @return the List of Week of which the plan is made of
	 */
	private final List<Week> computePlan(List<Story> openedStories, int pointsPerWeek){
		List<Week> plan = new LinkedList<Week>();
		while(!openedStories.isEmpty()){
			Week week = new Week(pointsPerWeek);
			plan.add(week);
			
			// now scan the whole remaining story-list, filling the week as much as possible
			Iterator<Story> iter = openedStories.iterator();
			while(iter.hasNext()){
				Story story = iter.next();
				// the story by itself exceed the week capacity
				if(story.getEstimatedPoints() > week.getMaxCapacity()){
					return null;
				}
				if(week.canHold(story)){
					week.addStory(story);
					iter.remove();
				}
			}
		}
		return plan;
	}
}
