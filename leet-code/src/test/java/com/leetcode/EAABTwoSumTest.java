package com.leetcode;

import org.junit.Test;

import com.leetcode.problems.EAABTwoSum;

public class EAABTwoSumTest {

	EAABTwoSum main = new EAABTwoSum();

	@Test
	public void test1() {
		int[] res = main.twoSum(new int[] { 2, 7, 11, 15 }, 9);
		org.junit.Assert.assertArrayEquals(new int[] { 0, 1 }, res);
	}

	@Test
	public void test2() {
		int[] res = main.twoSum(new int[] { 3, 2, 4 }, 6);
		org.junit.Assert.assertArrayEquals(new int[] { 1, 2 }, res);
	}

	@Test
	public void test3() {
		int[] res = main.twoSum(new int[] { 3, 3 }, 6);
		org.junit.Assert.assertArrayEquals(new int[] { 0, 1 }, res);
	}

}
