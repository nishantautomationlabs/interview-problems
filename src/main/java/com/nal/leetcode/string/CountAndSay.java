package com.nal.leetcode.string;

/**
 * Created by nishant on 02/02/20.
 * 38. Count and Say
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n <= 0)
            return "";

        String result = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < result.length(); j++) {
                int count = 1;
                while (j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
                    count++;
                    j++;
                }
                str.append(count).append(result.charAt(j));
            }
            result = str.toString();
        }
        return result;
    }
}
