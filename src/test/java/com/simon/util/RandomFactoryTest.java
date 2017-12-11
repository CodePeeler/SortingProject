package com.simon.util;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class RandomFactoryTest extends UtilAbstractTest {
	
	@Test
	public void getRandomObjectTest(){
		assertThat(RandomFactory.getRandomObject("Integer"), instanceOf(RandomInt.class));
		assertThat(RandomFactory.getRandomObject("Double"), instanceOf(RandomDouble.class));
	}
	
	@Test
	public void getRandomObjectListTest(){
		assertThat(RandomFactory.getRandomObjectList("Integer", 1).get(0), instanceOf(Integer.class));
		assertThat(RandomFactory.getRandomObjectList("Double", 1).get(0), instanceOf(Double.class));
	}
	
	@Test
	public void shouldHaveFiveElementsTest(){
		List<Integer> intArray = RandomFactory.getRandomObjectList("Integer", 5);
		assertEquals(intArray.size(), 5);		
	}

}
