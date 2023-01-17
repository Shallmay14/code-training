package com.leetcode.testcases.easy;

import com.leetcode.problems.easy.BEIARunningSumOf1dArray;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class BEIARunningSumOf1dArrayTest {

    BEIARunningSumOf1dArray main = new BEIARunningSumOf1dArray();

    @Test
    public void test1() {
        int[] res = main.runningSum(new int[]{1, 2, 3, 4});
        assertArrayEquals(new int[]{1, 3, 6, 10}, res);
    }

    @Test
    public void test2() {
        int[] res = main.runningSum(new int[]{1, 1, 1, 1, 1});
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, res);
    }

    @Test
    public void test3() {
        int[] res = main.runningSum(new int[]{3, 1, 2, 10, 1});
        assertArrayEquals(new int[]{3, 4, 6, 16, 17}, res);
    }
}
