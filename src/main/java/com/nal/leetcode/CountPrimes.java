package com.nal.leetcode;

import java.util.Arrays;

/**
 * Created by nishant on 05/02/20.
 */
public class CountPrimes {

    public int countPrimes(int n) {
        if (n <= 1)
            return 0;
        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
                for (int j = i * 2; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return count;
    }
}
