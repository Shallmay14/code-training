package com.titansoft.problems;

public class GetMiddleCharacters {

	public static String getMiddleCharacters(String inputStr) {

		if (inputStr.isEmpty())
			return "";

		int mid = inputStr.length() / 2;

		if (inputStr.length() % 2 == 0)
			return inputStr.substring(mid - 1, mid + 2);

		return inputStr.substring(mid, mid + 1);

	}

}
