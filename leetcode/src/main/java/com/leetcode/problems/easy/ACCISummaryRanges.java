package com.leetcode.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ACCISummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        var result = new ArrayList<String>();
        List<Integer> input = Arrays.stream(nums).boxed().collect(Collectors.toList());

        if (input.isEmpty()) return result;

        do {
            addParameter(input, result);
        } while (!input.isEmpty());
        return result;
    }

    private void addParameter(List<Integer> input, ArrayList<String> result) {
        var start = input.get(0);
        var end = input.get(0);

        // check if the next number is consecutive
        for (var i = 1; i < input.size(); i++) {
            if (input.get(i) == end + 1) {
				end = input.get(i);
            } else {
                break;
            }
        }

        // add the range to the result
        if (start.equals(end)) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }

        // remove the range from the input
		for (var i = 0; i <= end-start; i++) {
			input.remove(0);
		}
    }
}
