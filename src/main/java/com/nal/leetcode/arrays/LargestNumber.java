package com.nal.leetcode.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by nishant on 30/03/20.
 * 179. Largest Number
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * Example 1:
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        List<String> numbers = new ArrayList<>();
        for (int val : nums) {
            numbers.add(String.valueOf(val));
        }

        Collections.sort(numbers, (s1, s2) -> {
            String order1 = s1 + s2;
            String order2 = s2 + s1;
            return order1.compareTo(order2) > 0 ? -1 : 1;
        });

        if (numbers.get(0).equals("0"))
            return "0";
        StringBuilder result = new StringBuilder();
        for (String num : numbers) {
            result.append(num);
        }
        return result.toString();
    }
}
