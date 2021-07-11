package com.leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MJJASatisfiabilityOfEqualityEquations {

	private Map<String, List<String>> sameMap = new HashMap<>();
	private Map<String, List<String>> diffMap = new HashMap<>();

	public boolean equationsPossible(String[] equations) {

		if (equations.length <= 1)
			return true;

		List<Map<String, String>> list = getList(equations);

		return equationsPossible(list);
	}

	private List<Map<String, String>> getList(String[] equations) {

		List<Map<String, String>> list = new ArrayList<>();

		for (String equ : equations) {
			Map<String, String> map = new HashMap<>();
			map.put("v1", equ.substring(0, 1));
			map.put("compare", equ.substring(1, 3));
			map.put("v2", equ.substring(3, 4));
			list.add(map);
		}

		return list;
	}

	private boolean equationsPossible(List<Map<String, String>> list) {

		for (Map<String, String> map : list) {
			String v1 = map.get("v1");
			String v2 = map.get("v2");

			if ("==".equals(map.get("compare"))) {
				if (diffMap.containsKey(v1) && diffMap.get(v1).contains(v2))
					return false;
				saveSameOper(v1, v2);
			} else {
				if (sameMap.containsKey(v1) && sameMap.get(v1).contains(v2))
					return false;
				saveDiffOper(v1, v2);
			}
		}

		return true;
	}

	private void saveDiffOper(String v1, String v2) {
		List<String> list = new ArrayList<>();
		if (diffMap.containsKey(v1))
			list = diffMap.get(v1);
		list.add(v2);

		// TODO Auto-generated method stub

	}

	private void saveSameOper(String v1, String v2) {
		if (sameMap.containsKey(v1)) {
			sameMap.get(v1).equals(v2);
		}
		putTwiceMap(sameMap, v1, v2);
	}

	private void putTwiceMap(Map<String, List<String>> map, String v1, String v2) {
		putMap(map, v1, v2);
		putMap(map, v2, v1);
	}

	private void putMap(Map<String, List<String>> map, String v1, String v2) {
		List<String> list = map.get(v1);
		list.add(v2);
		if (map.containsKey(v2)) {
			list = Stream.concat(list.stream(), map.get(v2).stream()).collect(Collectors.toList());
		}
		map.put(v1, list);
	}

}
