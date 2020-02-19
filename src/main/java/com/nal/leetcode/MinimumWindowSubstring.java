package com.nal.leetcode;

/**
 * Created by nishant on 02/02/20.
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        String result = "";
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return result;
        int[] counter = new int[256];
        int count = 0;
        for (char c : t.toCharArray()) {
            counter[c]++;
        }
        int start = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            if (--counter[s.charAt(i)] >= 0) {
                count++;
            }
            while (count == t.length()) {
                if (min > i - start + 1) {
                    min = i - start + 1;
                    result = s.substring(start, i + 1);
                }
                if (++counter[s.charAt(start++)] > 0)
                    count--;
            }
        }
        return result;
    }
}
