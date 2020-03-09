package com.nal.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by nishant on 27/02/20.
 * 435. Non-overlapping Intervals
 * Given a collection of intervals, find the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * Example 1:
 * Input: [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of intervals are non-overlapping.
 */

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        int result = 0;
        if(intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return result;

        //sort by start date
        Arrays.sort(intervals, Comparator.comparingInt(s -> s[0]));
        for(int i = 1; i < intervals.length; i++) {
            if(overlaps(intervals[i], intervals[i-1])) {
                intervals[i][0] =  Math.max(intervals[i][0], intervals[i-1][0]);
                intervals[i][1] =  Math.min(intervals[i][1], intervals[i-1][1]);
                result++;
            }
        }
        return result;
    }

    public int eraseOverlapIntervals2(int[][] intervals) {
        int result = 0;
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return result;

        //sort by end date
        Arrays.sort(intervals, Comparator.comparingInt(s -> s[1]));
        int lastIncludedIndex = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (overlaps(intervals[i], intervals[lastIncludedIndex])) {
                result++;
            } else {
                lastIncludedIndex = i;
            }
        }
        return result;
    }

    public boolean overlaps(int[] a, int[] b) {
        if (a[0] < b[1] && b[0] < a[1])
            return true;
        return false;
    }
}
