package com.nal.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nishant on 07/02/20.
 */
public class HappyNumber {

    //O(1) space complexity
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        while (true) {
            slow = calValue(slow);
            fast = calValue(fast);
            fast = calValue(fast);
            if (slow == 1)
                return true;
            if (slow == fast)
                break;
        }
        return false;
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
