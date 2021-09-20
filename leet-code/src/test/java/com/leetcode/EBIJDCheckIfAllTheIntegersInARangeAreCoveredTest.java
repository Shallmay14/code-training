package com.leetcode;

import org.junit.Test;

import com.leetcode.problems.EBIJDCheckIfAllTheIntegersInARangeAreCovered;

public class EBIJDCheckIfAllTheIntegersInARangeAreCoveredTest {

	EBIJDCheckIfAllTheIntegersInARangeAreCovered main = new EBIJDCheckIfAllTheIntegersInARangeAreCovered();

	@Test
	public void test1() {
		boolean res = main.isCovered(new int[][] { new int[] { 1, 2 }, new int[] { 3, 4 }, new int[] { 5, 6 } }, 2, 5);
		org.junit.Assert.assertTrue(res);
	}

	@Test
	public void test2() {
		boolean res = main.isCovered(new int[][] { new int[] { 1, 10 }, new int[] { 10, 20 } }, 21, 21);
		org.junit.Assert.assertFalse(res);
	}

	@Test
	public void test3() {
		boolean res = main.isCovered(new int[][] { new int[] { 1, 1 } }, 1, 50);
		org.junit.Assert.assertFalse(res);
	}

	@Test
	public void test4() {
		boolean res = main.isCovered(new int[][] { new int[] { 1, 50 } }, 1, 50);
		org.junit.Assert.assertTrue(res);
	}

}
