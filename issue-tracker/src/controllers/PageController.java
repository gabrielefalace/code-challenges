package controllers;

import java.util.List;

import model.Bug;
import model.Issue;
import model.Story;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import services.FacadeService;
import services.PlannerService;
import common.Pages;
import common.Week;
import static common.IssueStates.*;

@Controller
@RequestMapping("/page")
public class PageController {

	@Autowired
	private FacadeService facade;
	
	@Autowired
	private PlannerService planGenerator;
	
	
	@RequestMapping("/listAll")
	public String listAllIssues(Model model) {
		List<Issue> list = facade.getAllIssues();
		model.addAttribute("listType", "All");
		model.addAttribute("list", list);
		return Pages.LIST;
	}

	
	@RequestMapping("/listOpen")
	public String listOpenIssues(Model model) {
		List<Issue> list = facade.getOpenedIssues();
		model.addAttribute("listType", "Open");
		model.addAttribute("list", list);
		return Pages.LIST;
	}

	
	@RequestMapping("/createIssue")
	public String goCreate(Model model) {
		model.addAttribute("bug", new Bug());
		model.addAttribute("story", new Story());
		model.addAttribute("bugStatusList", getBugStates());
		model.addAttribute("priorities", getBugPriorities());
		model.addAttribute("developers", facade.getDevelopersNames());
		model.addAttribute("storyStatusList", getStoryStates());
		
		return Pages.CREATE;
	}
	
	 
	@RequestMapping("/storyPlan")
	public String goStoryPlan(Model model){
		List<Week> plan = planGenerator.getStoryPlan();
		model.addAttribute("plan", plan);
		return Pages.STORY_PLAN;
	}

}
