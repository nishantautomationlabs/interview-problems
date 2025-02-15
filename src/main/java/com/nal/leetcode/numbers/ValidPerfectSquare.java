package com.nal.leetcode.numbers;

/**
 * Created by nishant on 27/02/20.
 * 367. Valid Perfect Square
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 * Note: Do not use any built-in library function such as sqrt.
 * Example 1:
 * Input: 16
 * Output: true
 * Example 2:
 * Input: 14
 * Output: false
 */
public class ValidPerfectSquare {

    public static void main(String[] args) {
        ValidPerfectSquare sol = new ValidPerfectSquare();
        System.out.println(sol.isPerfectSquare(2147483647));
    }

    public boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == (double) num / mid)
                return true;
            else if (mid > (double) num / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
