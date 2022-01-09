package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class MJJASatisfiabilityOfEqualityEquations {

	private static final String EQUAL = "==";

	private Map<String, List<String>> sameMap = new HashMap<>();
	private Map<String, List<String>> diffMap = new HashMap<>();

	public boolean equationsPossible(String[] equations) {

		for (String equ : equations) {
			String v1 = equ.substring(0, 1);
			boolean compare = EQUAL.equals(equ.substring(1, 3));
			String v2 = equ.substring(3, 4);

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

	private boolean findElement(String v1, String v2, Entry<String, List<String>> checkEntry) {
		return checkEntry.getKey().equals(v1) && checkEntry.getValue().contains(v2);
	}

	private void updateMap(String v1, boolean compare, String v2) {
		if (compare) {
			List<String> nestedList = new ArrayList<>();
			addElementToMap(v1, v2, sameMap, nestedList);
			addElementToMap(v2, v1, sameMap, nestedList);
			mergeElementToMap(v1, v2, diffMap);
		} else {
			addElementToMap(v1, v2, diffMap, new ArrayList<>());
			addElementToMap(v2, v1, diffMap, new ArrayList<>());
		}
	}

	private void addElementToMap(String key, String val, Map<String, List<String>> usedMap, List<String> nestedList) {
		if (!nestedList.contains(key)) {
			nestedList.add(key);

			if (sameMap.containsKey(key)) {
				for (String same : sameMap.get(key)) {
					addElementToMap(same, val, usedMap, nestedList);
				}
			}

			List<String> usedList = new ArrayList<>();
			if (usedMap.containsKey(key)) {
				usedList = usedMap.get(key);
			}
			usedList.add(val);
			usedMap.put(key, usedList);
		}
	}

	private void mergeElementToMap(String key1, String key2, Map<String, List<String>> usedMap) {
		List<String> diffList = new ArrayList<>();
		if (usedMap.containsKey(key1)) {
			diffList.addAll(usedMap.get(key1));
		}
		if (usedMap.containsKey(key2)) {
			diffList.addAll(usedMap.get(key2));
		}
		if (!diffList.isEmpty()) {
			usedMap.put(key1, diffList);
			usedMap.put(key2, diffList);
		}
	}

}
