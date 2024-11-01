package com.leetcode.problems.easy;

import com.leetcode.models.ListNode;
import com.leetcode.models.ListUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class ACAGReverseLinkedListTest {

    ACAGReverseLinkedList main = new ACAGReverseLinkedList();

    @Test
    public void test1() {

        // Arrange
        ListNode input = ListUtils.create(new Integer[]{1, 2, 3, 4, 5});

        // Act
        ListNode result = main.reverseList(input);

        // Assert
        assertArrayEquals(new Integer[]{5,4,3,2,1}, ListUtils.toArray(result));
    }
}