package com.nal.leetcode.string;

/**
 * Created by nishant on 09/02/20.
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string ""
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix commonPrefix = new LongestCommonPrefix();
        commonPrefix.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        int low = 1;
        int high = strs[0].length();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isCommonPrefix(strs, mid))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int mid) {
        String sub = strs[0].substring(0, mid);
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < sub.length() || !strs[i].startsWith(sub))
                return false;
        }
        return true;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];

        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || first.charAt(i) != strs[j].charAt(i))
                    return first.substring(0, i);
            }
        }
        return first;
    }
}
