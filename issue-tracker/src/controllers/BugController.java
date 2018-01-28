package controllers;

import static common.IssueStates.getBugPriorities;
import static common.IssueStates.getBugStates;
import model.Bug;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import services.FacadeService;
import common.Pages;

@Controller
@RequestMapping("/bug")
public class BugController {

	
	@Autowired
	private FacadeService facade;
	
	
	/**
	 * 
	 * @param bug
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String createOrUpdate(Bug bug, BindingResult bindingResult) {
		facade.save(bug); 
		return Pages.REDIRECT_HOME;
	}

	@RequestMapping(value = "/{issueId}", method = RequestMethod.GET)
	public String edit(@PathVariable String issueId, Model model) {
		Bug bug = (Bug) facade.getIssue(Long.parseLong(issueId));
		
		model.addAttribute("retrievedIssue", bug);
		
		model.addAttribute("bugStatusList", getBugStates());
		model.addAttribute("priorities", getBugPriorities());
		model.addAttribute("developers", facade.getDevelopersNames());
		
		return Pages.UPDATE;
	}

}
