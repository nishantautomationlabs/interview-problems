package com.nal.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nishant on 02/02/20.
 * 3. Longest Substring Without Repeating Characters
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeatingChar {

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int result = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while(right < s.length())
        {
            if(!set.contains(s.charAt(right)))
            {
                set.add(s.charAt(right++));
                result = Math.max(result, set.size());
            }
            else
            {
                set.remove(s.charAt(left++));
            }
        }
        return result;
    }
}
