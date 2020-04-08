package com.nal.leetcode.arrays;

/**
 * Created by nishant on 21/03/20.
 * 1004. Max Consecutive Ones III
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 * Example 1:
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * Output: 6
 */
public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] A, int K) {
        if (A == null || A.length == 0)
            return 0;

        int maxLength = 0;
        int start = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                K--;
                while (K < 0) {
                    if (A[start++] == 0) {
                        K++;
                    }
                }
            }
            maxLength = Math.max(maxLength, i - start + 1);
        }
        return maxLength;
    }
}
