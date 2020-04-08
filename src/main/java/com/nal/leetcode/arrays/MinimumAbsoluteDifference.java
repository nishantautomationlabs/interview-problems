package com.nal.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nishant on 29/03/20.
 * 1200. Minimum Absolute Difference
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 * Example 1:
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 */
public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr == null || arr.length == 0)
            return result;

        Arrays.sort(arr);
        int minLength = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < minLength) {
                minLength = arr[i] - arr[i - 1];
                result = new ArrayList<>();
            }
            if (arr[i] - arr[i - 1] == minLength) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[i - 1]);
                pair.add(arr[i]);
                result.add(pair);
            }
        }
        return result;
    }
}
