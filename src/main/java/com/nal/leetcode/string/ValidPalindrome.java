package com.nal.leetcode.string;

/**
 * Created by nishant on 02/02/20.
 * 125. Valid Palindrome
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * Example 1:
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if(s == null)
            return false;
        int left = 0, right = s.length()-1;

        while(left < right)
        {
            if(!Character.isLetterOrDigit(s.charAt(left)))
                left++;
            else if(!Character.isLetterOrDigit(s.charAt(right)))
                right--;
            else if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            else
            {
                left++;
                right--;
            }
        }
        return true;
    }
}
