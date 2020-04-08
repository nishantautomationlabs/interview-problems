package com.nal.leetcode.string;

/**
 * Created by nishant on 27/03/20.
 * 1189. Maximum Number of Balloons
 * Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.
 * You can use each character in text at most once. Return the maximum number of instances that can be formed.
 * Example 1:
 * Input: text = "nlaebolko"
 * Output: 1
 */
public class MaximumNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        if (text == null || text.length() == 0)
            return 0;
        int[] charFreq = new int[26];
        for (char c : text.toCharArray()) {
            charFreq[c - 'a']++;
        }
        int count = 0;
        boolean noMoreWord = false;
        while (!noMoreWord) {
            for (char c : "balloon".toCharArray()) {
                if (--charFreq[c - 'a'] < 0) {
                    noMoreWord = true;
                    break;
                }
            }
            if (!noMoreWord)
                count++;
        }
        return count;
    }
}
