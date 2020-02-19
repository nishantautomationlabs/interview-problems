package com.nal.leetcode.string;

/**
 * Created by nishant on 16/02/20.
 * 91. Decode Ways
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * Example 1:
 * Input: "12"
 * Output: 2
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            int singleDigit = Integer.valueOf(s.substring(i - 1, i));
            int doubleDigit = Integer.valueOf(s.substring(i - 2, i));
            if (singleDigit > 0)
                dp[i] += dp[i - 1];
            if (doubleDigit >= 10 && doubleDigit <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[s.length()];
    }
}
