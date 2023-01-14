package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MJJASatisfiabilityOfEqualityEquations {
	
	// Union Find
	
	// 1. 排序
	// 2. 整理同類
	// 3. 檢查異類
	// https://leetcode.com/problems/satisfiability-of-equality-equations/discuss/1645361/Java-Simple-Solution

	private static final String EQUAL = "==";

	private Map<String, List<String>> sameMap = new HashMap<>();
	private Map<String, List<String>> diffMap = new HashMap<>();

	public boolean equationsPossible(String[] equations) {

		for (String equ : equations) {
			var v1 = equ.substring(0, 1);
			boolean compare = EQUAL.equals(equ.substring(1, 3));
			var v2 = equ.substring(3, 4);

			if (!compare && v1.equals(v2))
				return false;

			if (!isComparePass(v1, compare, v2))
				return false;
		}

		return true;
	}

	private boolean isComparePass(String v1, boolean compare, String v2) {
		if (!checkSamePass(v1, compare, v2) || !checkDiffPass(v1, compare, v2))
			return false;
		updateMap(v1, compare, v2);
		return true;
	}

	private boolean checkSamePass(String v1, boolean compare, String v2) {
		if (compare) {
			return true;
		} else {
			if (!checkMapPass(v1, v2, sameMap))
				return false;
		}
		return true;
	}

	private boolean checkDiffPass(String v1, boolean compare, String v2) {
		if (compare) {
			if (!checkMapPass(v1, v2, diffMap))
				return false;
		} else {
			return true;
		}
		return true;
	}

	private boolean checkMapPass(String v1, String v2, Map<String, List<String>> checkMap) {
		for (Map.Entry<String, List<String>> checkEntry : checkMap.entrySet()) {
			if (findElement(v1, v2, checkEntry) || findElement(v2, v1, checkEntry))
				return false;
		}
		return true;
	}

	private boolean findElement(String key, String val, Entry<String, List<String>> checkEntry) {
		return checkEntry.getKey().equals(key) && checkEntry.getValue().contains(val);
	}

	private void updateMap(String v1, boolean compare, String v2) {
		if (compare) {
			List<String> sameList = new ArrayList<>();
			sameList.addAll(Arrays.asList(v1, v2));
			sameList = getSameListFromSameMap(v1, v2, sameList);
			sameList = getSameListFromSameMap(v2, v1, sameList);
			addElementsToSameMap(sameList);
			mergeElementToMap(v1, v2, diffMap);
		} else {
			addElementToDiffMap(v1, v2);
			addElementToDiffMap(v2, v1);
		}
	}

	private List<String> getSameListFromSameMap(String key, String val, List<String> sameList) {

		if (sameMap.containsKey(key))
			for (String same : sameMap.get(key))
				sameList = union(sameList, addElementToMap(same, val, sameMap));

		sameList = union(sameList, addElementToMap(key, val, sameMap));

		return sameList;
	}

	private void addElementsToSameMap(List<String> sameList) {
		for (String sameKey : sameList) {
			List<String> sameListWithoutKey = new ArrayList<>(sameList);
			sameListWithoutKey.remove(sameKey);
			sameMap.put(sameKey, sameListWithoutKey);
		}
	}

	private void addElementToDiffMap(String key, String val) {
		addElementToMap(key, val, diffMap);

		if (sameMap.containsKey(key)) {
			for (String same : sameMap.get(key)) {
				addElementToMap(same, val, diffMap);
			}
		}
	}

	private List<String> addElementToMap(String key, String val, Map<String, List<String>> usedMap) {
		List<String> usedList = new ArrayList<>();

		if (key.equals(val))
			return usedList;

		if (usedMap.containsKey(key)) {
			usedList = usedMap.get(key);
		}
		usedList.add(val);
		usedMap.put(key, usedList);
		return usedList;
	}

	private void mergeElementToMap(String key1, String key2, Map<String, List<String>> usedMap) {
		List<String> diffList = new ArrayList<>();
		if (usedMap.containsKey(key1)) {
			diffList = union(diffList, (usedMap.get(key1)));
		}
		if (usedMap.containsKey(key2)) {
			diffList = union(diffList, (usedMap.get(key2)));
		}
		if (!diffList.isEmpty()) {
			usedMap.put(key1, diffList);
			usedMap.put(key2, diffList);
		}
	}

	public <T> List<T> union(List<T> list1, List<T> list2) {
		Set<T> set = new HashSet<>();

		set.addAll(list1);
		set.addAll(list2);

		return new ArrayList<>(set);
	}

}
