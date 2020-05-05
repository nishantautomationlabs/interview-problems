package com.nal.leetcode.string;

import java.util.HashMap;

/**
 * Created by nishant on 04/02/20.
 * 387. First Unique Character in a String
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * Examples:
 * s = "leetcode"
 * return 0.
 * s = "loveleetcode",
 * return 2.
 */
public class FirstUniqueCharacterString {

    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0)
            return -1;

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
