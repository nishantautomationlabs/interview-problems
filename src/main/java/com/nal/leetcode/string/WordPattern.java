package com.nal.leetcode.string;

import java.util.HashMap;

/**
 * Created by nishant on 26/03/20.
 * 290. Word Pattern
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Example 1:
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null)
            return false;

        String[] words = str.split("\\s+");
        if (words.length != pattern.length())
            return false;
        HashMap<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (map.containsKey(c)) {
                if (!map.get(c).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                }
                map.put(c, words[i]);
            }
        }
        return true;
    }
}
