package dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Issue;
import model.Story;

import org.springframework.stereotype.Repository;

@Repository
public class IssueDAO {

	private EntityManager entityManager = Persistence.createEntityManagerFactory("issue-tracker").createEntityManager();

	/**
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Issue> getAllIssues() {
		List<Issue> foundIssues = null;
		Query query = entityManager.createNamedQuery("Issue.findAll");
		foundIssues = (List<Issue>) query.getResultList();
		return foundIssues;
	}

	/**
	 * 
	 * @return
	 */
	public List<Issue> getOpenedIssues() {
		List<Issue> openedIssues = new ArrayList<Issue>();

		// retrieve and add opened bugs to the result list
		openedIssues.addAll(getOpenedBugs());

		// also retrieving/adding opened stories
		openedIssues.addAll(getOpenedStories());
		return openedIssues;
	}

	@SuppressWarnings("unchecked")
	public List<Story> getOpenedStories() {
		Query openedStories = entityManager.createNamedQuery("Story.opened");
		return openedStories.getResultList();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Story> getOpenedBugs() {
		Query openedBugs = entityManager.createNamedQuery("Bug.opened");
		return openedBugs.getResultList();
	}
	
	
	/**
	 * 
	 * @param issueId
	 * @return
	 */
	public Issue getByIssueId(Long issueId) {
		Query query = entityManager.createNamedQuery("Issue.findById");
		query.setParameter("id", issueId);
		Issue issue = (Issue) query.getSingleResult();
		return issue;
	}

	/**
	 * 
	 * @param issue
	 */
	public void createOrUpdate(Issue issue) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		if(issue.getCreationDate() == null){
			Date d = Calendar.getInstance().getTime();
			issue.setCreationDate(d);
		}
		entityManager.merge(issue);
		tx.commit();
	}

}
