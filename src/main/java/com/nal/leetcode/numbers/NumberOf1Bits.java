package com.nal.leetcode.numbers;

/**
 * Created by nishant on 03/02/20.
 * 191. Number of 1 Bits
 * Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 * Example 1:
 * Input: 00000000000000000000000000001011
 * Output: 3
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        if (n == 0)
            return 0;
        int count = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            count += n & 1;
            n = n >> 1;
        }
        return count;
    }
}
