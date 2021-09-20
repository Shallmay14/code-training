package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class EBIJDCheckIfAllTheIntegersInARangeAreCovered {

	public boolean isCovered(int[][] ranges, int left, int right) {

		Map<Integer, Integer> needCover = new HashMap<>();
		for (int i = left; i <= right; i++) {
			needCover.put(i, 1);
		}

		for (int[] range : ranges) {
			for (int i = range[0]; i <= range[1]; i++) {
				needCover.remove(i);
			}
		}

		return needCover.isEmpty();

	}

}
