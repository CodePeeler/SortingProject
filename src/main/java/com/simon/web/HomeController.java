package com.simon.web;

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
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;

import com.simon.dom.Contact;
import com.simon.dom.Shop;
import com.simon.services.ContactService;

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
	
		
	@RequestMapping(value="/jsoneg", method = RequestMethod.GET, headers="Accept=application/json")
	public @ResponseBody Shop getShopInJSON() {
		logger.info("Welcome /{name} ");
		Shop shop = new Shop();
		
		shop.setStaffName(new String[]{"mkyong1", "mkyong2"});

		return shop;

	}
	
}
