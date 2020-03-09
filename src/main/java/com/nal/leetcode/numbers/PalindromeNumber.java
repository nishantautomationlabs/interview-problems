package com.nal.leetcode.numbers;

/**
 * Created by nishant on 05/03/20.
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * Example 1:
 * Input: 121
 * Output: true
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber number = new PalindromeNumber();
        System.out.println(number.isPalindrome(121));
        System.out.println(number.isPalindrome2(121));
    }

    public boolean isPalindrome2(int x) {
        if(x == 0)
            return true;

        if(x < 0 || x % 10 == 0)
            return false;

        int halfReversed = 0;
        while(x > halfReversed) {
            halfReversed = (halfReversed * 10) + (x % 10);
            x /= 10;
        }

        return halfReversed == x || halfReversed/10 == x;
    }

    public boolean isPalindrome(int x) {
        if (x == 0)
            return true;

        if (x < 0 || x % 10 == 0)
            return false;

        int reversed = 0;
        int xcopy = x;
        while (xcopy > 0) {
            reversed = (reversed * 10) + (xcopy % 10);
            xcopy /= 10;
        }
        return reversed == x;
    }
}
