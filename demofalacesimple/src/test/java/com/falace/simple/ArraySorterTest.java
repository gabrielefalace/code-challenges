package com.falace.simple;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * {@link ArraySorter}
 * Testing for the array sorting functionality.
 *
 * @author gabrielefalace
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemofalacesimpleApplication.class)
public class ArraySorterTest {

	@Autowired
	private ArraySorter arraySorter;

	/**
	 * Test for a regular int array.
	 * {@link ArraySorter#sort(int[])}
	 */
	@Test
	public void testSorted() {
		int[] values = { 4, 9, 1, 2 };
		int[] expected = { 1, 2, 4, 9 };

		// ArraySorter arraySorter = new ArraySorter();
		int[] result = arraySorter.sort(values);

		assertArrayEquals(expected, result);
	}

	/**
	 * Test for a single-element int array.
	 * {@link ArraySorter#sort(int[])}
	 */
	@Test
	public void testSortedSingleElement() {
		int[] values = { 4 };
		int[] expected = { 4 };

		// ArraySorter arraySorter = new ArraySorter();
		int[] result = arraySorter.sort(values);

		assertArrayEquals(expected, result);
	}

	/**
	 * Test for an empty array.
	 * {@link ArraySorter#sort(int[])}
	 */
	@Test
	public void testSortedEmpty() {
		int[] values = {};
		int[] expected = {};

		// ArraySorter arraySorter = new ArraySorter();
		int[] result = arraySorter.sort(values);

		assertArrayEquals(expected, result);
	}

}
