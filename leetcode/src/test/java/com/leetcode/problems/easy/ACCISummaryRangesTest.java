package com.leetcode.problems.easy;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ACCISummaryRangesTest {

    ACCISummaryRanges summaryRanges = new ACCISummaryRanges();

    @Test
    public void test1() {

        // Arrange
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};
        List<String> expected = List.of("0->2", "4->5", "7");

        // Act
        List<String> actual = summaryRanges.summaryRanges(nums);

        // Assert
        assertThat(actual, is(expected));

    }

    @Test
    public void test2() {

        // Arrange
        int[] nums = new int[]{0, 2, 3, 4, 6, 8, 9};
        List<String> expected = List.of("0", "2->4", "6", "8->9");

        // Act
        List<String> actual = summaryRanges.summaryRanges(nums);

        // Assert
        assertThat(actual, is(expected));

    }

    @Test
    public void test3() {

        // Arrange
        int[] nums = new int[]{-2147483648,-2147483647,2147483647};
        List<String> expected = List.of("-2147483648->-2147483647", "2147483647");

        // Act
        List<String> actual = summaryRanges.summaryRanges(nums);

        // Assert
        assertThat(actual, is(expected));

    }
}