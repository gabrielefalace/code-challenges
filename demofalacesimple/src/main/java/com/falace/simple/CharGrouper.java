package com.falace.simple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharGrouper {

	@Autowired
	private ArraySorter arraySorter;

	@Autowired
	private StringCompressor compressor;

	public String group(String ungrouped) {
		char[] arr = ungrouped.toCharArray();
		String sorted = new String(arraySorter.sort(arr));
		String compressed = compressor.compress(sorted);
		return compressed;
	}

}
