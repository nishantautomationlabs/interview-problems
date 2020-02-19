package com.nal.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nishant on 09/02/20.
 * 771. Jewels and Stones
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 */
public class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null || J.length() == 0 || S.length() == 0)
            return 0;

        int res = 0;
        Set<Character> set = new HashSet<>();
        for (char c : J.toCharArray())
            set.add(c);
        for (char c : S.toCharArray()) {
            if (set.contains(c))
                res++;
        }
        return res;
    }
}
