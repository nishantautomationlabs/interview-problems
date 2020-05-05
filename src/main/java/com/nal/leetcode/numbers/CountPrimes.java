package com.nal.leetcode.numbers;

import java.util.Arrays;

/**
 * Created by nishant on 05/02/20.
 * 204. Count Primes
 * Count the number of prime numbers less than a non-negative number, n.
 * Example:
 * Input: 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */
public class CountPrimes {

//    O(NLogLogN)
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
