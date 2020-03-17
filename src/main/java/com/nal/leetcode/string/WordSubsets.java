package com.nal.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nishant on 14/03/20.
 * 916. Word Subsets
 * We are given two arrays A and B of words.  Each word is a string of lowercase letters.
 * Now, say that word b is a subset of word a if every letter in b occurs in a, including multiplicity.  For example, "wrr" is a subset of "warrior", but is not a subset of "world".
 * Now say a word a from A is universal if for every b in B, b is a subset of a.
 * Return a list of all universal words in A.  You can return the words in any order.
 * Example 1:
 * Input: A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
 * Output: ["facebook","google","leetcode"]
 */
public class WordSubsets {
    public static void main(String[] args) {
        WordSubsets wordSubsets = new WordSubsets();
        wordSubsets.wordSubsets(new String[]{"amazon", "apple", "facebook", "google", "leetcode"}, new String[] {"e","o"});
    }

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> result = new ArrayList<>();
        if(A == null || A.length == 0 || B == null || B.length == 0) {
            return result;
        }

        int[] maxFreq = new int[26];
        for(String subword : B) {
            int[] charFreq =getCharFrequency(subword);
            for(int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], charFreq[i]);
            }
        }
        for(String word : A) {
            boolean isValid = true;
            int[] freq = getCharFrequency(word);
            for(int i = 0; i < 26; i++){
                if(maxFreq[i] > freq[i]) {
                    isValid = false;
                    break;
                }
            }
            if(isValid)
                result.add(word);
        }
        return result;
    }

    private int[] getCharFrequency(String input) {
        int[] charFreq = new int[26];
        for(char c : input.toCharArray()) {
            charFreq[c - 'a']++;
        }
        return charFreq;
    }
}
