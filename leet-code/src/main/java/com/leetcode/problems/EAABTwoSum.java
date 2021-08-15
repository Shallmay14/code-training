package com.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class EAABTwoSum {

	public int[] twoSum(int[] nums, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		for (var i = 0; i < nums.length; i++) {
			int delta = target - nums[i];

			if (map.containsKey(delta))
				return new int[] { i, map.get(delta) };

			map.put(nums[i], i);
		}

		return new int[2];

	}

}
