package com.nal.leetcode;

/**
 * Created by nishant on 02/02/20.
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        String result = "";
        if (s == null || t == null || s.length() == 0 || t.length() == 0)
            return result;
        int[] charFreq = new int[256];
        int count = 0;
        for (char c : t.toCharArray()) {
            charFreq[c]++;
        }
        int left = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            if (--charFreq[s.charAt(right)] >= 0) {
                count++;
            }
            while (count == t.length()) {
                if (min > right - left + 1) {
                    min = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                if (++charFreq[s.charAt(left)] > 0)
                    count--;
                left++;
            }
        }
        return result;
    }
}
