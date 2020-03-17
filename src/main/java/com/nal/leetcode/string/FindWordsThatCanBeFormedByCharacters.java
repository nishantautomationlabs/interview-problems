package com.nal.leetcode.string;

import java.util.Arrays;

/**
 * Created by nishant on 15/03/20.
 * 1160. Find Words That Can Be Formed by Characters
 * You are given an array of strings words and a string chars.
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * Return the sum of lengths of all good strings in words.
 * Example 1:
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 */
public class FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        if (chars == null || chars.length() == 0 || words == null || words.length == 0)
            return 0;

        int[] charFreq = new int[26];
        for (char c : chars.toCharArray()) {
            charFreq[c - 'a']++;
        }

        int result = 0;
        for (String word : words) {
            if (canBeFormed(word, Arrays.copyOf(charFreq, 26))) {
                result += word.length();
            }
        }
        return result;
    }

    private boolean canBeFormed(String word, int[] charFreq) {
        for (char c : word.toCharArray()) {
            if (--charFreq[c - 'a'] < 0)
                return false;
        }
        return true;
    }
}
