package com.leetcode;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.problems.MJJASatisfiabilityOfEqualityEquations;

public class MJJASatisfiabilityOfEqualityEquationsTest {

	MJJASatisfiabilityOfEqualityEquations main = new MJJASatisfiabilityOfEqualityEquations();

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

}
