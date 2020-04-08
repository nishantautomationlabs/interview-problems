package com.nal.leetcode.arrays;

/**
 * Created by nishant on 20/03/20.
 * 908. Smallest Range I
 * Given an array A of integers, for each integer A[i] we may choose any x with -K <= x <= K, and add x to A[i].
 * After this process, we have some array B.
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 * Example 1:
 * Input: A = [0,10], K = 2
 * Output: 6
 */
public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        if (A == null || A.length == 0)
            return 0;

        int minValue = A[0];
        int maxValue = A[0];
        for (int i = 0; i < A.length; i++) {
            minValue = Math.min(minValue, A[i]);
            maxValue = Math.min(maxValue, A[i]);
        }
        int val = (maxValue - K) - (minValue + K);
        return val < 0 ? 0 : val;
    }
}
