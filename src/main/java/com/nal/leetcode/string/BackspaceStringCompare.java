package com.nal.leetcode.string;

/**
 * Created by nishant on 10/02/20.
 * 844. Backspace String Compare
 * Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 */
public class BackspaceStringCompare {

    public static void main(String[] args) {
        BackspaceStringCompare compare = new BackspaceStringCompare();
        compare.backspaceCompare2("sasasasc", "a#d#c");
    }

    public boolean backspaceCompare2(String S, String T) {
        if (S == null || T == null)
            return false;
        int sLength = S.length() - 1, tLength = T.length() - 1;
        int sHashCount = 0, tHashCount = 0;
        while (sLength >= 0 || tLength >= 0) {
            while (sLength >= 0 && (S.charAt(sLength) == '#' || sHashCount > 0)) {
                if (S.charAt(sLength--) == '#')
                    sHashCount++;
                else
                    sHashCount--;
            }
            while (tLength >= 0 && (T.charAt(tLength) == '#' || tHashCount > 0)) {
                if (T.charAt(tLength--) == '#')
                    tHashCount++;
                else
                    tHashCount--;
            }
            if (sLength < 0 || tLength < 0)
                return sLength == tLength;
            if (S.charAt(sLength--) != T.charAt(tLength--))
                return false;
        }
        return sLength == tLength;
    }

    public boolean backspaceCompare(String S, String T) {
        if (S == null || T == null)
            return false;
        return processedStr(S).equals(processedStr(T));
    }

    private String processedStr(String str) {
        StringBuilder sb = new StringBuilder();
        int hashCount = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '#' || hashCount > 0) {
                if (str.charAt(i) == '#')
                    hashCount++;
                else
                    hashCount--;
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
