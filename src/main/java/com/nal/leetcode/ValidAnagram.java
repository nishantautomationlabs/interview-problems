package com.nal.leetcode;

/**
 * Created by nishant on 04/02/20.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length())
            return false;

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (--freq[c - 'a'] < 0)
                return false;
        }
        return true;
    }
}
