package com.nal.leetcode.string;

/**
 * Created by nishant on 21/03/20.
 * 424. Longest Repeating Character Replacement
 * Given a string s that consists of only uppercase English letters, you can perform at most k operations on that string.
 * In one operation, you can choose any character of the string and change it to any other uppercase English character.
 * Find the length of the longest sub-string containing all repeating letters you can get after performing the above operations.
 * Note:
 * Both the string's length and k will not exceed 104.
 * Example 1:
 * Input:
 * s = "ABAB", k = 2
 * Output:
 * 4
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;

        int[] charFreq = new int[26];
        int left = 0;
        int maxElementCount = 0;
        int result = 0;
        for (int right = 0; right < s.length(); right++) {
            charFreq[s.charAt(right) - 'A']++;
            maxElementCount = Math.max(maxElementCount, charFreq[s.charAt(right) - 'A']);
            while (right - left + 1 - k > maxElementCount) {
                charFreq[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
