package com.nal.leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by nishant on 18/03/20.
 * 819. Most Common Word
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.
 * Example:
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 */
public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.toLowerCase().split("\\W+");
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;
        String result = null;
        for (String word : words) {
            if (!set.contains(word)) {
                int freq = map.getOrDefault(word, 0) + 1;
                if (freq > count) {
                    count = freq;
                    result = word;
                }
                map.put(word, freq);
            }
        }
        return result;
    }
}
