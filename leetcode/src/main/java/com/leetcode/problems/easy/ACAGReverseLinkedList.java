package com.leetcode.problems.easy;

import com.leetcode.models.ListNode;

public class ACAGReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        return reverseList(head.next, new ListNode(head.val));
    }

    private ListNode reverseList(ListNode head, ListNode temp) {
        if (head == null) return temp;
        ListNode result = new ListNode(head.val);
        result.next = temp;
        return reverseList(head.next, result);
    }
}
