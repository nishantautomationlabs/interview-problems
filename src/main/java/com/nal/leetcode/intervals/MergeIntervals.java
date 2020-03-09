package com.nal.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by nishant on 26/02/20.
 * 56. Merge Intervals
 * Given a collection of intervals, merge all overlapping intervals.
 * Example 1:
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(s -> s[0]));

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int[] interval : intervals) {
            if (interval[0] <= stack.peek()[1]) {
                int[] temp = stack.pop();
                temp[1] = Math.max(temp[1], interval[1]);
                stack.push(temp);
            } else {
                stack.push(interval);
            }
        }

        int[][] result = new int[stack.size()][2];
        int i = 0;
        while (!stack.isEmpty()) {
            result[i++] = stack.pop();
        }
        return result;
    }
}
