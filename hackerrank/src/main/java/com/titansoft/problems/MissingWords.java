package com.titansoft.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MissingWords {

	public static List<String> missingWords(String s, String t) {
		// Write your code here
		List<String> input = new ArrayList<>(Arrays.asList(s.split(" ")));
		List<String> filter = new ArrayList<>(Arrays.asList(t.split(" ")));
//		Map<String, Integer> filterMap = new HashMap<>();

//		for (String str : filter) {
//			if (!filterMap.containsKey(str))
//				filterMap.put(str, 0);
//			filterMap.put(str, filterMap.get(str) + 1);
//		}
//
//		for (String str : input) {
//			if (filterMap.containsKey(str))
//				if (filterMap.get(str) == 1)
//					filterMap.remove(str);
//				else
//					filterMap.put(str, filterMap.get(str) - 1);
//			else
//				output.add(str);
//		}

		int index = 0;

		for (int i = 0; i < input.size(); i++) {
			if (filter.get(index).equals(input.get(i))) {
				input.remove(i);
				i--;
				index++;
			}
			if (index >= filter.size())
				break;
		}

		return input;
	}

	public static void main(String[] args) {
		missingWords("aa bb cc", "aa bb");
	}
}
