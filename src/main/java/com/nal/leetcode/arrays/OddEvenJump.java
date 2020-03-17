package com.nal.leetcode.arrays;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by nishant on 15/03/20.
 * 975. Odd Even Jump
 * You are given an integer array A.  From some starting index, you can make a series of jumps.  The (1st, 3rd, 5th, ...) jumps in the series are called odd numbered jumps, and the (2nd, 4th, 6th, ...) jumps in the series are called even numbered jumps.
 * You may from index i jump forward to index j (with i < j) in the following way:
 * During odd numbered jumps (ie. jumps 1, 3, 5, ...), you jump to the index j such that A[i] <= A[j] and A[j] is the smallest possible value.  If there are multiple such indexes j, you can only jump to the smallest such index j.
 * During even numbered jumps (ie. jumps 2, 4, 6, ...), you jump to the index j such that A[i] >= A[j] and A[j] is the largest possible value.  If there are multiple such indexes j, you can only jump to the smallest such index j.
 * (It may be the case that for some index i, there are no legal jumps.)
 * A starting index is good if, starting from that index, you can reach the end of the array (index A.length - 1) by jumping some number of times (possibly 0 or more than once.)
 * Return the number of good starting indexes.
 * Example 1:
 * Input: [10,13,12,14,15]
 * Output: 2
 */
public class OddEvenJump {
    public int oddEvenJumps(int[] A) {
        if (A == null || A.length == 0)
            return 0;

        int n = A.length;
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];

        odd[n - 1] = true;
        even[n - 1] = true;

        int result = 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A[n - 1], n - 1);
        for (int i = n - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> ceilingEntry = map.ceilingEntry(A[i]);
            Map.Entry<Integer, Integer> floorEntry = map.floorEntry(A[i]);
            odd[i] = ceilingEntry == null ? false : even[ceilingEntry.getValue()];
            even[i] = floorEntry == null ? false : odd[floorEntry.getValue()];
            if (odd[i]) {
                result++;
            }
            map.put(A[i], i);
        }
        return result;
    }
}
