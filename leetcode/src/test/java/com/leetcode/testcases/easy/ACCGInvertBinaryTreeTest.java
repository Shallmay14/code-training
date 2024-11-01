package com.leetcode.testcases.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.leetcode.models.TreeUtils;
import com.leetcode.models.TreeNode;
import com.leetcode.problems.easy.ACCGInvertBinaryTree;

public class ACCGInvertBinaryTreeTest {

	ACCGInvertBinaryTree main = new ACCGInvertBinaryTree();

	@Test
	public void test1() {
		TreeNode res = main.invertTree(TreeUtils.create(new Integer[] { 4, 2, 7, 1, 3, 6, 9 }));
		assertEquals(new int[] { 4, 7, 2, 9, 6, 3, 1 }, TreeUtils.toList(res));
	}

	@Test
	public void test2() {
		TreeNode res = main.invertTree(TreeUtils.create(new Integer[] { 2, 1, 3 }));
		assertEquals(TreeUtils.create(new Integer[] { 2, 3, 1 }), res);
	}

	@Test
	public void test3() {
		TreeNode res = main.invertTree(TreeUtils.create(new Integer[] {}));
		assertEquals(TreeUtils.create(new Integer[] {}), res);
	}

}
