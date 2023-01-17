package com.leetcode.testcases.easy;

import com.leetcode.problems.easy.BGHCRichestCustomerWealth;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BGHCRichestCustomerWealthTest {

    BGHCRichestCustomerWealth main = new BGHCRichestCustomerWealth();

    @Test
    public void test1() {
        assertEquals(6, main.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
    }

    @Test
    public void test2() {
        assertEquals(10, main.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
    }

    @Test
    public void test3() {
        assertEquals(17, main.maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}));
    }
}
