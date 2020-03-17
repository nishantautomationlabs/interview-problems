package com.nal.leetcode.arrays;

/**
 * Created by nishant on 14/03/20.
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 * You may return any answer array that satisfies this condition.
 * Example 1:
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        if (A == null || A.length == 0)
            return null;

        int evenPtr = 0;
        for (int oddPtr = 1; oddPtr < A.length; oddPtr += 2) {
            if (A[oddPtr] % 2 == 0) {
                while (evenPtr < A.length && A[evenPtr] % 2 == 0) {
                    evenPtr += 2;
                }
                int temp = A[oddPtr];
                A[oddPtr] = A[evenPtr];
                A[evenPtr] = temp;
            }
        }
        return A;
    }
}
