package com.leetcode.problems.easy;

import com.leetcode.models.TreeNode;

public class ABABSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return checkSymmetric(root.left, root.right);
    }

    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if ((left == null && right != null)
                || (left != null && right == null)
                || (left.val.equals(right.val)))
            return false;
        return checkSymmetric(left.left, right.right) && checkSymmetric(left.right, right.left);
    }
}
