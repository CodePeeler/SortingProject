package com.simon.web;

import com.simon.algorithms.SelectionSort;
import com.simon.algorithms.SortAlgorithm;
import com.simon.dom.Trial;
import com.simon.services.AlgorithmService;
import com.simon.services.ContactService;
import com.simon.dom.Contact;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	private AlgorithmService algorithmService;	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private ContactService contactService;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		model.addAttribute("message", "Secret message from home controller");
		return "home";
	}
			
	@RequestMapping(value={"/sort"}, method=RequestMethod.GET, headers={"Accept=application/json"})
	@ResponseBody
	public List<Trial<Integer>> getTrialInJSON(Model uiModel) {
		logger.info("At getTrialInJSON controller ");
		
		int arraySize = 10;
		String arrayType = "Integer";
		int numOfTrials = 1;
		SortAlgorithm<Integer> selectionSort = new SelectionSort<>();		
	
		List<Trial<Integer>> trials = algorithmService.runTrial(arraySize, arrayType, numOfTrials, selectionSort);
		uiModel.addAttribute("trial", trials.get(0));
	    //Trial<Integer> trial = (Trial<Integer>)resultSet.get(0);
	    //List<Integer> data = trial.getData();	    
	    return trials;
	  }
	
	@RequestMapping(value={"/sort2"}, method=RequestMethod.GET)
	public String getTrial(Model uiModel) {
		logger.info("*** At getTrial controller ");
		
		
		int arraySize = 10;
		String arrayType = "Integer";
		int numOfTrials = 1;
		SortAlgorithm<Integer> selectionSort = new SelectionSort<>();		
		/*
		List<Trial<Integer>> trials = algorithmService.runTrial(arraySize, arrayType, numOfTrials, selectionSort);
		*/
		List<Trial<Integer>> result = algorithmService.dumbTrial(arraySize, arrayType, numOfTrials);
		uiModel.addAttribute("result", result);
	    //Trial<Integer> trial = (Trial<Integer>)resultSet.get(0);
	    //List<Integer> data = trial.getData();	    
	    return "trial";
	  }
	
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String list(Model uiModel) {
		logger.info("Listing contacts");
		List<Contact> contacts = contactService.findAll();
		uiModel.addAttribute("contacts", contacts);
		logger.info("No. of contacts: " + contacts.size());
		return "contacts/list";
	}

}
