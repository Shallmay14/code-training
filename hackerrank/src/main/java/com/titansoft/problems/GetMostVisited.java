package com.titansoft.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetMostVisited {

	public static int getMostVisited(int n, List<Integer> sprints) {
		// Write your code here
		Map<Integer, Integer> visits = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			visits.put(i, 0);
		}

		int start = sprints.get(0);
		for (int i = 1; i < sprints.size(); i++) {
			int end = sprints.get(i);
			if (start > end) {
				for (int j = end; j <= start; j++) {
					visits.put(j, visits.get(j) + 1);
				}
			} else {
				for (int j = start; j <= end; j++) {
					visits.put(j, visits.get(j) + 1);
				}
			}
			start = end;
		}

		int max = 1;
		int maxValue = 0;
		for (Integer key : visits.keySet()) {
			if (visits.get(key) > maxValue) {
				maxValue = visits.get(key);
				max = key;
			}
		}

		return max;
	}

	public static void main(String[] args) {
		List<Integer> sprints = Arrays.asList(9, 7, 3, 1);
		getMostVisited(9, sprints);
	}

}
