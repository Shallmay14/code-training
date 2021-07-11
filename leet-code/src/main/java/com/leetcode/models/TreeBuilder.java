package com.leetcode.models;

import java.util.ArrayList;
import java.util.List;

public class TreeBuilder {

	private TreeBuilder() {
		throw new IllegalStateException("Builder class");
	}

	public static TreeNode create(int[] arr) {
		if (arr.length == 0)
			return null;

		if (arr.length > 2)
			return new TreeNode(arr[0], create(getLeftArr(arr)), create(getRightArr(arr)));
		if (arr.length > 1)
			return new TreeNode(arr[0], create(getLeftArr(arr)), null);
		return new TreeNode(arr[0]);
	}

	private static int[] getLeftArr(int[] arr) {
		var end = 2;
		var level = 1;
		var mid = 1;
		List<Integer> list = new ArrayList<>();
		for (var i = 1; i < arr.length; i++) {
			if (i <= mid)
				list.add(arr[i]);
			if (end == i) {
				level++;
				int count = (int) Math.pow(2, level);
				mid += count / 2;
				end += count;
			}
		}
		return toArray(list);
	}

	private static int[] getRightArr(int[] arr) {
		var end = 2;
		var level = 1;
		var mid = 1;
		List<Integer> list = new ArrayList<>();
		for (var i = 1; i < arr.length; i++) {
			if (i > mid && i <= end)
				list.add(arr[i]);
			if (end == i) {
				level++;
				int count = (int) Math.pow(2, level);
				mid += count / 2;
				end += count;
			}
		}
		return toArray(list);
	}

	private static int[] toArray(List<Integer> list) {
		var arr = new int[list.size()];
		for (var i = 0; i < list.size(); i++)
			arr[i] = list.get(i);
		return arr;
	}

}
