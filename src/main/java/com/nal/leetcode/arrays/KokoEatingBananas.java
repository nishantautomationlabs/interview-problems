package com.nal.leetcode.arrays;

import java.util.Arrays;

/**
 * Created by nishant on 04/03/20.
 * 875. Koko Eating Bananas
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.
 * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 * Example 1:
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 */
public class KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int H) {
        if (piles == null || piles.length == 0 || H == 0)
            return 0;

        int max = getMaxPiles(piles);
        int left = 1;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int hours = getHours(piles, mid);
            if (hours > H) {
                left = mid + 1;
            } else
                right = mid;
        }
        return left;
    }

    private int getHours(int[] piles, int mid) {
        int result = 0;
        for (int val : piles) {
            result += val % mid == 0 ? val / mid : val / mid + 1;
        }
        return result;
    }

    private int getMaxPiles(int[] piles) {
        return Arrays.stream(piles).max().getAsInt();
//        int max = piles[0];
//        for (int i = 1; i < piles.length; i++) {
//            if (piles[i] > max) {
//                max = piles[i];
//            }
//        }
//        return max;
    }
}
