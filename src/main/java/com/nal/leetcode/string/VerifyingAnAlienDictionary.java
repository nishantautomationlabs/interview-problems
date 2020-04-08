package com.nal.leetcode.string;

/**
 * Created by nishant on 21/03/20.
 * 953. Verifying an Alien Dictionary
 */
public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0)
            return true;
        int[] charOrder = new int[26];
        for (int i = 0; i < order.length(); i++) {
            charOrder[order.charAt(i) - 'a'] = i;
        }
        for (int i = 1; i < words.length; i++) {
            if (compare(words[i - 1], words[i], charOrder) > 0)
                return false;
        }
        return true;
    }

    private int compare(String s1, String s2, int[] charOrder) {
        int i = 0;
        int j = 0;
        while (i < s1.length() && j < s2.length()) {
            int diff = charOrder[s1.charAt(i) - 'a'] - charOrder[s2.charAt(j) - 'a'];
            if (diff != 0) {
                return diff;
            }
            i++;
            j++;
        }
        return s1.length() - s2.length();
    }
}
