package com.nal.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 29/03/20.
 * 438. Find All Anagrams in a String
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 * Example 1:
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 * [0, 6]
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;
        int[] charFreq = new int[26];
        for (char c : p.toCharArray()) {
            charFreq[c - 'a']++;
        }
        int left = 0;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {

            if (--charFreq[s.charAt(right) - 'a'] >= 0) {
                count++;
            }
            if (right - left + 1 == p.length()) {
                if (count == p.length()) {
                    result.add(left);
                }
                if (++charFreq[s.charAt(left) - 'a'] > 0) {
                    count--;
                }
                left++;
            }
        }
        return result;
    }
}
