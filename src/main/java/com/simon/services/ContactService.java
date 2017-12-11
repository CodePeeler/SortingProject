package com.simon.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.simon.dom.Contact;

@Component
public class ContactService {
	
	public List<Contact> findAll() {
		List<Contact> contacts = new ArrayList<Contact>();
		contacts.add(new Contact());
		return contacts;
		}

}
