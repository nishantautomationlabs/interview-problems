package com.nal.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by nishant on 07/05/20.
 * 139. Word Break
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * Note:
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        HashMap<String, Boolean> hashMap = new HashMap<>();

        for (String word : wordDict) {
            set.add(word);
        }
//        return wordBreakUsingRecursion(s, set);
//        return wordBreakUsingRecursionAndMemoization(s, set, hashMap);
        return wordBreakUsingDynamicProgramming(s, set);
    }

    private boolean wordBreakUsingRecursion(String string, Set<String> set) {
        if (string.equals(""))
            return true;

        for (int i = 1; i <= string.length(); i++) {
            if (set.contains(string.substring(0, i)) && wordBreakUsingRecursion(string.substring(i), set))             {
                 System.out.println(string.substring(0, i));
                return true;
            }
        }
        return false;
    }

    private boolean wordBreakUsingRecursionAndMemoization(String string, Set<String> set, HashMap<String, Boolean> hashMap) {
        if (string.equals(""))
            return true;
        else if (hashMap.containsKey(string))
            return hashMap.get(string);

        for (int i = 1; i <= string.length(); i++) {
            if (set.contains(string.substring(0, i)) && wordBreakUsingRecursionAndMemoization(string.substring(i), set, hashMap)) {
                // System.out.println(string.substring(0, i));
                hashMap.put(string, true);
                return true;
            }
        }
        hashMap.put(string, false);
        return false;
    }

    private boolean wordBreakUsingDynamicProgramming(String string, Set<String> set) {
        boolean[] dp = new boolean[string.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= string.length(); i++) {
//            for (int j = 0; j < string.length(); j++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(string.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[string.length()];
    }


}
