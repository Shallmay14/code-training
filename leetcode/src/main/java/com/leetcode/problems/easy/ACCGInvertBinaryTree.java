package com.leetcode.problems.easy;

import com.leetcode.models.TreeNode;

public class ACCGInvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		var node = new TreeNode(root.val);
		node.left = invertTree(root.right);
		node.right = invertTree(root.left);
		return node;
	}
}
