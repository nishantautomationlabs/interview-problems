package com.nal.leetcode.numbers;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nishant on 07/02/20.
 * 202. Happy Number
 * Write an algorithm to determine if a number n is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * Return True if n is a happy number, and False if not.
 */
public class HappyNumber {

    //O(1) space complexity
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        while (slow != 1) {
            slow = calValue(slow);
            fast = calValue(fast);
            fast = calValue(fast);
            if (slow == fast)
                break;
        }
        return slow == 1;
    }

    public boolean isHappyIterative(int n) {
        if (n == 0)
            return false;

        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            if (set.contains(n))
                return false;
            set.add(n);
            n = calValue(n);
        }
        return true;
    }

    private int calValue(int n) {
        int value = 0;
        while (n != 0) {
            value += (n % 10) * (n % 10);
            n = n / 10;
        }
        return value;
    }

    public boolean isHappyRecursive(int n) {
        if (n == 0)
            return false;

        Set<Integer> set = new HashSet<Integer>();
        return isHappyNumber(n, set);
    }

    private boolean isHappyNumber(int n, Set<Integer> set) {
        if (n == 1)
            return true;
        if (set.contains(n))
            return false;

        set.add(n);
        int value = 0;
        while (n != 0) {
            value += (n % 10) * (n % 10);
            n = n / 10;
        }
        return isHappyNumber(value, set);
    }
}
