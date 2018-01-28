package common;

import java.util.ArrayList;
import java.util.List;

/**
 * This class holds values collection commonly used by controllers, such as
 * bugs/stories status and bugs priorities
 * 
 * @author gabriele
 * 
 */
public class IssueStates {

	private IssueStates() {	}

	private static List<String> bugStates, storyStates, priorities;

	static {
		bugStates = new ArrayList<String>();
		bugStates.add("VERIFIED");
		bugStates.add("RESOLVED");

		priorities = new ArrayList<String>();
		priorities.add("MINOR");
		priorities.add("MAJOR");
		priorities.add("CRITICAL");

		storyStates = new ArrayList<String>();
		storyStates.add("ESTIMATED");
		storyStates.add("COMPLETED");
	}

	public static List<String> getStoryStates() {
		return storyStates;
	}

	public static List<String> getBugStates() {
		return bugStates;
	}

	public static List<String> getBugPriorities() {
		return priorities;
	}

}
