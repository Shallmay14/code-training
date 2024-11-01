package com.leetcode.testcases.easy;

import com.leetcode.models.TreeUtils;
import com.leetcode.problems.easy.CCDGRootEqualsSumOfChildren;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CCDGRootEqualsSumOfChildrenTest {

    CCDGRootEqualsSumOfChildren main = new CCDGRootEqualsSumOfChildren();

    @Test
    public void test1() {
        boolean res = main.checkTree(TreeUtils.create(new Integer[]{10, 4, 6}));
        assertTrue(res);
    }

    @Test
    public void test2() {
        boolean res = main.checkTree(TreeUtils.create(new Integer[]{5, 3, 1}));
        assertFalse(res);
    }
}
