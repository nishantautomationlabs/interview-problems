package com.nal.leetcode.arrays;

/**
 * Created by nishant on 29/03/20.
 * 775. Global and Local Inversions
 * We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.
 * The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].
 * The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].
 * Return true if and only if the number of global inversions is equal to the number of local inversions.
 * Example 1:
 * Input: A = [1,0,2]
 * Output: true
 */
public class GlobalAndLocalInversions {
    public boolean isIdealPermutation(int[] A) {
        if (A == null || A.length == 0)
            return false;

        int max = A[0];
        for (int i = 2; i < A.length; i++) {
            if (max > A[i])
                return false;
            max = Math.max(max, A[i - 1]);
        }
        return true;
    }
}
