package com.leetcode.problems.easy;

import com.leetcode.models.TreeNode;

public class CCDGRootEqualsSumOfChildren {
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }
}
