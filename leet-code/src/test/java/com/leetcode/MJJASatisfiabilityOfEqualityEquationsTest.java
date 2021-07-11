package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

import com.leetcode.problems.MJJASatisfiabilityOfEqualityEquations;

public class MJJASatisfiabilityOfEqualityEquationsTest {

	MJJASatisfiabilityOfEqualityEquations main = new MJJASatisfiabilityOfEqualityEquations();

	@Test
	public void test1() {
		boolean res = main.equationsPossible(new String[] { "a==b", "b!=a" });
		Assert.assertEquals(false, res);
	}

	@Test
	public void test2() {
		boolean res = main.equationsPossible(new String[] { "b==a", "a==b" });
		Assert.assertEquals(true, res);
	}

	@Test
	public void test3() {
		boolean res = main.equationsPossible(new String[] { "a==b", "b==c", "a==c" });
		Assert.assertEquals(true, res);
	}

	@Test
	public void test4() {
		boolean res = main.equationsPossible(new String[] { "a==b", "b!=c", "c==a" });
		Assert.assertEquals(false, res);
	}

	@Test
	public void test5() {
		boolean res = main.equationsPossible(new String[] { "c==c", "b==d", "x!=z" });
		Assert.assertEquals(true, res);
	}

}
