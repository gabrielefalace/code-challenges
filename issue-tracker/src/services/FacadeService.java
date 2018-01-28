package services;

import java.util.List;

import model.Issue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DeveloperDAO;
import dao.IssueDAO;

@Service
public class FacadeService {

	
	@Autowired 
	private IssueDAO issueDAO;
	
	@Autowired
	private DeveloperDAO developerDAO;
	
	
	public List<Issue> getAllIssues(){
		return issueDAO.getAllIssues();
	}
	
	
	public List<Issue> getOpenedIssues(){
		return issueDAO.getOpenedIssues();
	}
	
	
	public List<String> getDevelopersNames(){
		return developerDAO.getDevelopersNames();
	}
	
	
	public Issue getIssue(Long issueId){
		return issueDAO.getByIssueId(issueId);
	}
	
	public void save(Issue issue){
		issueDAO.createOrUpdate(issue);
	}
}
