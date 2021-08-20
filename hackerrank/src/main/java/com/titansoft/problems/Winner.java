package com.titansoft.problems;

import java.util.List;

public class Winner {

	public static String winner(List<Integer> andrea, List<Integer> maria, String s) {
		// Write your code here
		int start = "Even".equals(s) ? 0 : 1;
		int sum = 0;

		for (int i = start; i < andrea.size(); i += 2) {
			sum += andrea.get(i) - maria.get(i);
		}

		if (sum == 0)
			return "Tie";
		else if (sum > 0)
			return "Andrea";
		else
			return "Maria";

	}

}
