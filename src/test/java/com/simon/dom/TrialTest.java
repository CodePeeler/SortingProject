package com.simon.dom;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class TrialTest extends DomAbstractTest {
	
	@Autowired
	BeanTester meanBean;
	
	@Test
	public void getterAndSetterCorrectness() throws Exception {
		// Automates testing of properties that have public getter and setter methods.
		meanBean.testBean(Trial.class);
	}

}