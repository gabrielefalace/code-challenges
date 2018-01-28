package controllers;


import static common.IssueStates.getStoryStates;
import model.Story;

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
@RequestMapping("/story")
public class StoryController {

	@Autowired
	private FacadeService facade;


	@RequestMapping(method = RequestMethod.POST)
	public String handlePersistence(Story story, BindingResult bindingResult) {
		facade.save(story);
		return Pages.REDIRECT_HOME;
	}

	@RequestMapping(value = "/{issueId}", method = RequestMethod.GET)
	public String edit(@PathVariable String issueId, Model model) {
		Story story = (Story) facade.getIssue(Long.parseLong(issueId));
		model.addAttribute("retrievedIssue", story);

		model.addAttribute("storyStatusList", getStoryStates());
		model.addAttribute("developers", facade.getDevelopersNames());

		return Pages.UPDATE;
	}

}
