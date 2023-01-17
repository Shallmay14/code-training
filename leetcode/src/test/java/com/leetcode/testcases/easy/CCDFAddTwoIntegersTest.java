package com.leetcode.testcases.easy;

import com.leetcode.problems.easy.CCDFAddTwoIntegers;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CCDFAddTwoIntegersTest {

    CCDFAddTwoIntegers main = new CCDFAddTwoIntegers();

    @Test
    public void test1() {
        assertEquals(17, main.sum(12, 5));
    }

    @Test
    public void test2() {
        assertEquals(-6, main.sum(-10, 4));
    }
}
