package com.simon.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import com.simon.dom.Contact;
import com.simon.services.ContactService;

@ActiveProfiles("test")
public class ContactControllerTest extends ControllerAbstractTest {
	
	private final List<Contact> contacts = new ArrayList<Contact>();
	private ContactService contactService;
	
	@Autowired
	private Contact contact;
	
	@Before
	public void initContacts() {
		// Initialize list of contacts for mocked ContactService
		contact.setId(1l);
		contact.setFirstName("Simon");
		contact.setLastName("Dornan");
		contacts.add(contact);
	}
	
	@Test
	public void testList() throws Exception {
		
		contactService = mock(ContactService.class);
		when(contactService.findAll()).thenReturn(contacts);
		
		//contactService variable, which will be injected by Spring in normal situations,
		HomeController contactController = new HomeController();
		ReflectionTestUtils.setField(contactController, "contactService", contactService);
		
		ExtendedModelMap uiModel = new ExtendedModelMap();
		String result = contactController.list(uiModel);
		assertNotNull(result);
		assertEquals(result, "contacts/list");
		@SuppressWarnings("unchecked")
		List<Contact> modelContacts = ((List<Contact>) uiModel.get("contacts"));
		assertEquals(1, modelContacts.size());
		
	}

}