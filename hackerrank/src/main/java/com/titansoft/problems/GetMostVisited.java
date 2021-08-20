package com.titansoft.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetMostVisited {

	private static int maxValue = 1;
	private static int minIndex = 1;
	private static Map<Integer, Integer> visits = new HashMap<>();

	public static int getMostVisited(int n, List<Integer> sprints) {

		int start = sprints.get(0);

		for (int i = 1; i < sprints.size(); i++) {
			int end = sprints.get(i);
			if (start > end)
				addValue(end, start);
			else
				addValue(start, end);
			start = end;
		}

		return minIndex;
	}

	private static void addValue(int min, int max) {
		for (int i = min; i <= max; i++) {
			int value = visits.containsKey(i) ? visits.get(i) + 1 : 1;
			visits.put(i, value);
			if (value > maxValue) {
				minIndex = i;
				maxValue = value;
			} else if (value == maxValue && minIndex > i) {
				minIndex = i;
			}
		}
	}

	public static void main(String[] args) {
		List<Integer> sprints = Arrays.asList(9, 7, 3, 1);
		getMostVisited(9, sprints);
	}

}
