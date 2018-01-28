package com.falace.simple;

import java.util.Arrays;

import org.springframework.stereotype.Service;

@Service
public class ArraySorter {

	public int[] sort(int[] unsorted) {
		int[] copy = Arrays.copyOf(unsorted, unsorted.length);
		Arrays.sort(copy);
		return copy;
	}

	public char[] sort(char[] unsorted) {
		char[] copy = Arrays.copyOf(unsorted, unsorted.length);
		Arrays.sort(copy);
		return copy;
	}

}
