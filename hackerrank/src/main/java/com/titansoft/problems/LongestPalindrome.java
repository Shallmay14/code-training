package com.titansoft.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestPalindrome {

	public static int longestPalindrome(int n, String s) {

		int maxLength = 1;
		List<String> posStr = Arrays.asList(s.split(""));
		List<String> negStr = Arrays.asList(s.split(""));
		Collections.reverse(negStr);
		int hit = 0;
		int hitStart = 0;
		int hitEnd = 0;

		for (int i = 0; i < posStr.size(); i++) {
			String pStr = posStr.get(i);
			for (int j = 0; j < negStr.size(); j++) {
				String nStr = negStr.get(j);
				if (pStr.equals(nStr)) {
					hitStart = i;
					hitEnd = j;
					if (i == j) {
						return maxLength;
					}
				}
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {
		longestPalindrome(7, "bandana");
	}

}
