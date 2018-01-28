package com.falace.simple;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemofalacesimpleApplication.class)
public class CharGrouperTest {

	@Autowired
	private CharGrouper charGrouper;

	@Test
	public void test() {
		String input = "abzuaaissna"; // aaaabinssuz
		String expected = "a4bins2uz";

		String result = charGrouper.group(input);

		Assert.assertTrue(expected.equals(result));
	}

}