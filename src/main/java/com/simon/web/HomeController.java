package com.simon.web;

import com.simon.algorithms.SelectionSort;
import com.simon.algorithms.SortAlgorithm;
import com.simon.dom.Contact;
import com.simon.dom.Trial;
import com.simon.services.AlgorithmService;
import com.simon.services.ContactService;
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
	private ContactService contactService;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
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
	/*
	 * This is a dumb - created to test the testing framework - not to be called from UI.
	 */
	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String list(Model uiModel) {
		logger.info("Listing contacts");
		List<Contact> contacts = contactService.findAll();
		uiModel.addAttribute("contacts", contacts);
		logger.info("No. of contacts: " + contacts.size());
		return "contacts/list";
		
	}
	
	/*
	 * Return JSON object to client.
	 */
	@RequestMapping(value = "/contactsJSON", method = RequestMethod.GET)
	public @ResponseBody List<Contact> listJSON(Model uiModel) {
		Contact contact = new Contact();
		contact.setId(1l);
		contact.setFirstName("Simon");
		contact.setLastName("Dornan");
		List<Contact> contacts = new ArrayList<>();
		contacts.add(contact);
		logger.info("Listing contacts");
		
		uiModel.addAttribute("contacts", contacts);
		logger.info("No. of contacts: " + contacts.size());
		return contacts;
	}		
	
	
	@RequestMapping(value={"/sort"}, method=RequestMethod.GET, headers={"Accept=application/json"})
	@ResponseBody
	public Trial<Integer> getTrialInJSON() {
		logger.info("At getTrialInJSON controller ");
	
		AlgorithmService algorithmService = new AlgorithmService();
		SortAlgorithm<Integer> selectionSort = new SelectionSort<>();
	
		List<Trial<Integer>> resultSet = algorithmService.runTrial(10, "Integer", 1, selectionSort);
	    Trial<Integer> trial = (Trial<Integer>)resultSet.get(0);
	    //List<Integer> data = trial.getData();
	    
	    return trial;
	  }

}
