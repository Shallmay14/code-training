package com.leetcode.problems.easy;

import java.util.ArrayList;

public class ACCFImplementStackUsingQueues {

	ArrayList<Integer> list;

	public ACCFImplementStackUsingQueues() {
		list = new ArrayList<>();
	}

	public void push(int x) {
		list.add(x);
	}

	public int pop() {
		int val = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return val;
	}

	public int top() {
		return list.get(list.size() - 1);
	}

	public boolean empty() {
		return list.isEmpty();
	}
}
