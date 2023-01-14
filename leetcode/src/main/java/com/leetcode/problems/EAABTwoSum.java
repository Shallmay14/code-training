package com.leetcode.problems;
public class EAABTwoSum {

  public int[] twoSum(int[] nums, int target) {

    for (var i = 0; i < nums.length; i++)
      for (var j = i + 1; j < nums.length; j++)
        if (target == (nums[i] + nums[j]))
          return new int[] {i, j};

    return new int[0];
  }
}
