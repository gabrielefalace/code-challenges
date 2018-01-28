package com.falace.simple;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CharGrouperMockedTest {

	@Mock
	ArraySorter arraySorter;

	@Spy
	StringCompressor stringCompressor;

	@InjectMocks
	CharGrouper charGrouper;

	@Ignore
	@Test
	public void strangeTestEmpty() {
		when(arraySorter.sort(Matchers.any(char[].class)))
				.thenReturn("".toCharArray());
		when(stringCompressor.compress(anyString()))
				.thenReturn("");

		String result = charGrouper.group("gethteh");

		verify(stringCompressor, times(1)).compress(anyString());

		assertTrue(result.isEmpty());
	}

	@Test
	public void strangeTestSuccess() {
		when(arraySorter.sort(Matchers.any(char[].class))).thenReturn("abcdef".toCharArray());

		when(stringCompressor.compress("abcdef")).thenReturn("SUCCESS");

		String result = charGrouper.group("abcdef");

		verify(stringCompressor, times(1)).compress(anyString());

		assertTrue("SUCCESS".equals(result));
	}

}
