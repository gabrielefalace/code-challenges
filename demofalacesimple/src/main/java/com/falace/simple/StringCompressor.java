package com.falace.simple;

import org.springframework.stereotype.Service;

@Service
public class StringCompressor {

	public String compress(String uncompressed) {
		int uncompressedLength = uncompressed.length();

		if (uncompressedLength == 0 || uncompressedLength == 1) {
			return uncompressed;
		}

		StringBuilder stringBuilder = new StringBuilder().append(uncompressed.charAt(0));

		int counter = 1;

		for (int i = 1; i < uncompressedLength; i++) {
			char previousChar = uncompressed.charAt(i - 1);
			char currentChar = uncompressed.charAt(i);
			if (currentChar == previousChar) {
				counter++;
			} else {
				if (counter > 1) {
					stringBuilder.append(counter);
					counter = 1;
				}
				stringBuilder.append(currentChar + "");
			}
		}

		if (counter > 1) {
			stringBuilder.append(counter);
		}

		String result = stringBuilder.toString();

		if (result.length() == uncompressedLength) {
			return uncompressed;
		} else {
			return result;
		}
	}

}
