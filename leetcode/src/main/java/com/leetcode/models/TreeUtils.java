package com.leetcode.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeUtils {

	private TreeUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static Integer[] toList(TreeNode node) {
		return toArray(toIntegerList(node));
	}

	public static Integer[] toIntegerList(TreeNode node) {
		List<Integer> list = new ArrayList<>();
		list.add(node.val);
		if (node.left != null)
			list.addAll(Arrays.asList(toIntegerList(node.left)));
		if (node.right != null)
			list.addAll(Arrays.asList(toIntegerList(node.right)));
		return toIntegerArray(list);
	}

	public static TreeNode create(Integer[] arr) {
		if (arr.length == 0)
			return null;

		if (arr.length > 2)
			return new TreeNode(arr[0], create(getLeftArr(arr)), create(getRightArr(arr)));
		if (arr.length > 1)
			return new TreeNode(arr[0], create(getLeftArr(arr)), null);
		return new TreeNode(arr[0]);
	}

	private static Integer[] getLeftArr(Integer[] arr) {
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
				mid = end + count / 2;
				end += count;
			}
		}
		return toArray(list);
	}

	private static Integer[] getRightArr(Integer[] arr) {
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
				mid = end + count / 2;
				end += count;
			}
		}
		return toArray(list);
	}

	private static Integer[] toArray(List<Integer> list) {
		var arr = new Integer[list.size()];
		for (var i = 0; i < list.size(); i++)
			arr[i] = list.get(i);
		return arr;
	}

	private static Integer[] toIntegerArray(List<Integer> list) {
		var arr = new Integer[list.size()];
		for (var i = 0; i < list.size(); i++)
			arr[i] = list.get(i);
		return arr;
	}

	private static Integer[] toArray(Integer[] integerList) {
		var arr = new Integer[integerList.length];
		for (var i = 0; i < integerList.length; i++)
			arr[i] = (int) integerList[i];
		return arr;
	}

}
