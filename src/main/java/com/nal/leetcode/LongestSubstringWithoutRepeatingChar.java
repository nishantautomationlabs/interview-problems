package com.nal.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by nishant on 02/02/20.
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
                result = Math.max(result, right - left);
            }
            else
            {
                set.remove(s.charAt(left++));
            }
        }
        return result;
    }
}
