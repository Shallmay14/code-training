package com.leetcode.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListUtils {

	private ListUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static ListNode create(Integer[] arr) {
		if (arr.length == 0)
			return null;

		if (arr.length == 1)
			return new ListNode(arr[0]);

		return new ListNode(arr[0], create(Arrays.copyOfRange(arr, 1, arr.length)));
	}

	public static Integer[] toArray(ListNode node) {
		List<Integer> list = new ArrayList<>();
		while (node != null) {
			list.add(node.val);
			node = node.next;
		}
		return list.toArray(new Integer[0]);
	}

}
