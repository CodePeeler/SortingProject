package com.simon.util;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class RandomDoubleTest extends UtilAbstractTest {
			
	@Autowired
	RandomDouble randomDouble;	
	
	@Test
	public void randomDoubleShouldNotBeNull() {
		assertNotNull(randomDouble);
	}
	
	@Test
	public void getRandomObjectTest(){
		// Implicitly tests generate method.
		assertThat(randomDouble.getRandomObject(), instanceOf(Double.class));
	}
	
}