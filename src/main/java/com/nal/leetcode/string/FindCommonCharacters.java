package com.nal.leetcode.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nishant on 14/03/20.
 * 1002. Find Common Characters
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.
 * You may return the answer in any order.
 * Example 1:
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 */
public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> result = new ArrayList<>();
        if (A == null || A.length == 0)
            return result;

        int[] charFreq = new int[26];
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);
        for (int j = 0; j < A.length; j++) {
            Arrays.fill(charFreq, 0);
            for (char c : A[j].toCharArray()) {
                charFreq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charFreq[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add("" + (char) (i + 'a'));
                minFreq[i]--;
            }
        }
        return result;
    }
}
