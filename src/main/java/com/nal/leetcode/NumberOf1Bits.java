package com.nal.leetcode;

/**
 * Created by nishant on 03/02/20.
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
