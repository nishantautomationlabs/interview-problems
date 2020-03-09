package com.nal.leetcode.arrays;

import java.util.TreeMap;

/**
 * Created by nishant on 06/03/20.
 * 846. Hand of Straights
 * Alice has a hand of cards, given as an array of integers.
 * Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
 * Return true if and only if she can.
 * Example 1:
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
 * Output: true
 * Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8].
 */

public class HandOfStraights {

    public boolean isNStraightHand(int[] hand, int W) {
        if (hand == null || hand.length == 0 || hand.length % W != 0)
            return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int val : hand) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        while (map.size() > 0) {
            int key = map.firstKey();
            for (int i = 0; i < W; i++) {
                if (map.containsKey(key)) {
                    int val = map.get(key);
                    if (--val > 0) {
                        map.put(key, val);
                    } else {
                        map.remove(key);
                    }
                    key++;
                } else
                    return false;
            }
        }
        return true;
    }
}
