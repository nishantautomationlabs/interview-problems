package com.nal.leetcode.arrays;

/**
 * Created by nishant on 05/02/20.
 * 896. Monotonic Array
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 * Return true if and only if the given array A is monotonic.
 * Example 1:
 * Input: [1,2,2,3]
 * Output: true
 */
public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        if (A == null || A.length <= 1)
            return true;

        boolean increasing = true, decreasing = true;

        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] > A[i + 1])
                increasing = false;
            if (A[i] < A[i + 1])
                decreasing = false;
        }
        return increasing || decreasing;
    }
}
