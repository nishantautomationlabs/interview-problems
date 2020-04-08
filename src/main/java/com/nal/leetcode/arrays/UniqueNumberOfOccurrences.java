package com.nal.leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by nishant on 28/03/20.
 * 1207. Unique Number of Occurrences
 * Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.
 * Example 1:
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 */
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0)
            return true;

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int val : arr) {
            countMap.put(val, countMap.getOrDefault(val, 0) + 1);
        }
        HashSet<Integer> values = new HashSet<>(countMap.values());

        return values.size() == countMap.size();
    }
}
