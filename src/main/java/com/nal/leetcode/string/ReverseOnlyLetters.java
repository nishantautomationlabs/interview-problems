package com.nal.leetcode.string;

/**
 * Created by nishant on 10/03/20.
 * 917. Reverse Only Letters
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 * Example 1:
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 */
public class ReverseOnlyLetters {
    public String reverseOnlyLetters(String S) {
        if(S == null)
            return S;

        StringBuilder sb = new StringBuilder(S);
        int left = 0;
        int right = S.length() - 1;
        while(left < right) {
            while(left < right && !Character.isLetter(sb.charAt(left))) {
                left++;
            }
            while(left < right && !Character.isLetter(sb.charAt(right))) {
                right--;
            }
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
        return sb.toString();
    }
}
