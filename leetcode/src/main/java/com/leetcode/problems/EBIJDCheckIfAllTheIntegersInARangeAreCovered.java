package com.leetcode.problems;

public class EBIJDCheckIfAllTheIntegersInARangeAreCovered {

	public boolean isCovered(int[][] ranges, int left, int right) {

		boolean[] covered = new boolean[50];

		for (int[] range : ranges) {
			for (int i = range[0]; i <= range[1]; i++) {
				covered[i - 1] = true;
			}
		}

		for (int i = left; i <= right; i++) {
			if (!covered[i - 1]) {
				return false;
			}
		}

		return true;
	}

}
