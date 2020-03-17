package com.nal.leetcode.numbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 14/03/20.
 * 728. Self Dividing Numbers
 * A self-dividing number is a number that is divisible by every digit it contains.
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 * Also, a self-dividing number is not allowed to contain the digit zero.
 * Given a lower and upper number bound, output a list of every possible self dividing number, including the bounds if possible.
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 */
public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        if(left > right)
            return result;

        for(int i = left; i <= right; i++) {
            if(isSelfDividing(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean isSelfDividing(int num) {
        int value = num;
        while(value > 0) {
            int rem = value % 10;
            if(rem == 0 || num % rem != 0)
                return false;
            value = value / 10;
        }
        return true;
    }
}
