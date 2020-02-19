package com.nal.leetcode;

import java.util.HashMap;

/**
 * Created by nishant on 04/02/20.
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
