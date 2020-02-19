package com.nal.leetcode.string;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by nishant on 16/02/20.
 * 720. Longest Word in Dictionary
 * Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.
 * If there is no answer, return the empty string.
 * Example 1:
 * Input:
 * words = ["w","wo","wor","worl", "world"]
 * Output: "world"
 */
public class LongestWordInDictionary {
        public static void main(String[] args) {
            String[] input = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
            LongestWordInDictionary sol = new LongestWordInDictionary();
            String res = sol.longestWord(input);
            System.out.println("Output is: " + res);
        }

        private String longestWord(String[] words) {
            String result = "";
            if (words == null || words.length == 0) {
                return result;
            }
            Arrays.sort(words);
            Set<String> set = new HashSet<>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() == 1 || set.contains(words[i].substring(0, words[i].length() - 1))) {
                    set.add(words[i]);
                    if (words[i].length() > result.length()) {
                        result = words[i];
                    }
                }
            }
            return result;
        }
}
