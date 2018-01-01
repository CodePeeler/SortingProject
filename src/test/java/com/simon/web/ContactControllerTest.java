package com.simon.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import com.simon.algorithms.SelectionSort;
import com.simon.algorithms.SortAlgorithm;
import com.simon.dom.Trial;
import com.simon.services.AlgorithmService;
import com.simon.dom.Contact;
import com.simon.services.ContactService;

@ActiveProfiles("test")
public class ContactControllerTest extends ControllerAbstractTest {
	
	private final List<Contact> contacts = new ArrayList<Contact>();
	private ContactService contactService;
	
		
	private List<Trial<Integer>> trials = new ArrayList<Trial<Integer>>();
	private AlgorithmService algorithmService;
	/**/	
	@Before
	public void initTrials() {	
		Trial<Integer> trial = new Trial<Integer>();		
		List<Integer> array = new ArrayList<>();
		array.add(new Integer(3));
		array.add(new Integer(7));
		array.add(new Integer(1));
		trial.setData(array);
		trials.add(trial);
	}
	
	@Before
	public void initContacts() {
		// Initialize list of contacts for mocked ContactService
		Contact contact = new Contact();
		contact.setId(1l);
		contact.setFirstName("John");
		contact.setLastName("Doe");
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
		System.out.println("modelContacts.get(0).getFirstName() -> "+modelContacts.get(0).getFirstName());
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testRunTrial() throws Exception {
		/**/
		int arraySize = 10;
		String arrayType = "Integer";
		int numOfTrials = 1;
		//SortAlgorithm<Integer> selectionSort = new SelectionSort<>();
		
				
		algorithmService = mock(AlgorithmService.class);
		when(algorithmService.dumbTrial(arraySize, arrayType, numOfTrials)).thenReturn(trials);
		//when(contactService.findAll()).thenReturn(contacts);
		HomeController sortController = new HomeController();
		ReflectionTestUtils.setField(sortController, "algorithmService", algorithmService);		
		
		ExtendedModelMap uiModel = new ExtendedModelMap();		
		String result = sortController.getTrial(uiModel);
		
		assertNotNull(result);
		assertEquals(result, "trial");

		
		//@SuppressWarnings("unchecked")
		/*
		List<Trial<Integer>> resultList = (List<Trial<Integer>>) uiModel.get("trials");
		System.out.print("resultList -> "+resultList.toString());
		assertEquals(1, resultList.size());		
		*/
		@SuppressWarnings("unchecked")
		List<Trial<Integer>> xResult = (List<Trial<Integer>>) uiModel.get("result");
		//assertEquals(xResult, "ReplacedDumbTrial");
		System.out.print("xResult  "+xResult.get(0).getData());
	}
/**/
}