package com.nal.leetcode.string;

/**
 * Created by nishant on 15/03/20.
 * 482. License Key Formatting
 * You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.
 * Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.
 * Given a non-empty string S and a number K, format the string according to the rules described above.
 * Example 1:
 * Input: S = "5F3Z-2e-9-w", K = 4
 * Output: "5F3Z-2E9W"
 */
public class LicenseKeyFormatting {
    public String licenseKeyFormatting(String S, int K) {
        if(S == null || S.length() == 0)
            return S;

        S = S.toUpperCase().replaceAll("-", "").trim();
        StringBuilder sb = new StringBuilder(S);
        for(int i = S.length() - K; i > 0; i = i - K) {
            sb.insert(i, "-");
        }
        return sb.toString();
    }
}
