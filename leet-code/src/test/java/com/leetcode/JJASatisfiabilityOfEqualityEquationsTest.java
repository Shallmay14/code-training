package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class JJASatisfiabilityOfEqualityEquationsTest {

	@Test
	public void test1() {
		JJASatisfiabilityOfEqualityEquations main = new JJASatisfiabilityOfEqualityEquations();
		boolean res = main.equationsPossible(new String[] { "a==b", "b!=a" });
		Assert.assertEquals(false, res);
	}

	@Test
	public void test2() {
		JJASatisfiabilityOfEqualityEquations main = new JJASatisfiabilityOfEqualityEquations();
		boolean res = main.equationsPossible(new String[] { "b==a", "a==b" });
		Assert.assertEquals(true, res);
	}

	@Test
	public void test3() {
		JJASatisfiabilityOfEqualityEquations main = new JJASatisfiabilityOfEqualityEquations();
		boolean res = main.equationsPossible(new String[] { "a==b", "b==c", "a==c" });
		Assert.assertEquals(true, res);
	}

	@Test
	public void test4() {
		JJASatisfiabilityOfEqualityEquations main = new JJASatisfiabilityOfEqualityEquations();
		boolean res = main.equationsPossible(new String[] { "a==b", "b!=c", "c==a" });
		Assert.assertEquals(false, res);
	}

	@Test
	public void test5() {
		JJASatisfiabilityOfEqualityEquations main = new JJASatisfiabilityOfEqualityEquations();
		boolean res = main.equationsPossible(new String[] { "c==c", "b==d", "x!=z" });
		Assert.assertEquals(true, res);
	}

}
