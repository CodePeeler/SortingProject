package com.simon.util;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class RandomIntTest extends UtilAbstractTest {
		
	@Autowired
	RandomInt randomInt;
			
	@Test
	public void randomIntShouldNotBeNull() {
		assertNotNull(randomInt);
	}
	
	@Test
	public void getRandomObjectTest(){
		assertThat(randomInt.getRandomObject(), instanceOf(Integer.class));
	}
	
}