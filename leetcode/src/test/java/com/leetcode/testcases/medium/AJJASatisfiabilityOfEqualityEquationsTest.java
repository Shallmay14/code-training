package com.leetcode.testcases.medium;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.problems.medium.AJJASatisfiabilityOfEqualityEquations;

public class AJJASatisfiabilityOfEqualityEquationsTest {

	AJJASatisfiabilityOfEqualityEquations main = new AJJASatisfiabilityOfEqualityEquations();

	@Test
	public void test1() {
		boolean res = main.equationsPossible(new String[] { "a==b", "b!=a" });
		assertEquals(false, res);
	}

	@Test
	public void test2() {
		boolean res = main.equationsPossible(new String[] { "b==a", "a==b" });
		assertEquals(true, res);
	}

	@Test
	public void test3() {
		boolean res = main.equationsPossible(new String[] { "a==b", "b==c", "a==c" });
		assertEquals(true, res);
	}

	@Test
	public void test4() {
		boolean res = main.equationsPossible(new String[] { "a==b", "b!=c", "c==a" });
		assertEquals(false, res);
	}

	@Test
	public void test5() {
		boolean res = main.equationsPossible(new String[] { "c==c", "b==d", "x!=z" });
		assertEquals(true, res);
	}

	@Test
	public void test6() {
		boolean res = main.equationsPossible(new String[] { "a!=a" });
		assertEquals(false, res);
	}

	@Test
	public void test7() {
		boolean res = main.equationsPossible(new String[] { "a==b", "e==c", "b==c", "a!=e" });
		assertEquals(false, res);
	}

}
