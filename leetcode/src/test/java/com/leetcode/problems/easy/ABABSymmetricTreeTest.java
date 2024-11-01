package com.leetcode.problems.easy;

import com.leetcode.models.TreeNode;
import com.leetcode.models.TreeUtils;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ABABSymmetricTreeTest {

    ABABSymmetricTree main = new ABABSymmetricTree();

    @Test
    public void test1() {
        // Arrange
        TreeNode root = TreeUtils.create(new Integer[]{1,2,2,3,4,4,3});

        // Act
        boolean expected = main.isSymmetric(root);

        // Assert
        assertTrue(expected);
    }

    @Test
    public void test2() {
        // Arrange
        TreeNode root = TreeUtils.create(new Integer[]{1,2,2,null,3,null,3});

        // Act
        boolean expected = main.isSymmetric(root);

        // Assert
        assertFalse(expected);
    }

    @Test
    public void test3() {
        // Arrange
        TreeNode root = TreeUtils.create(new Integer[]{2, 3, 3, 4, 5, 5});

        // Act
        boolean expected = main.isSymmetric(root);

        // Assert
        assertFalse(expected);
    }
}