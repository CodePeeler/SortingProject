package com.simon.web;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class) //Indicates the runner classes used to execute the test case.
@ContextConfiguration(classes = {ControllerTestConfig.class})//Indicates to the Spring JUnit runner the configuration to be loaded.
@TestExecutionListeners(listeners = { DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class})
public abstract class ControllerAbstractTest {

}
