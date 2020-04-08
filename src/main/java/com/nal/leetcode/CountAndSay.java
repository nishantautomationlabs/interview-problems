package com.nal.leetcode;

/**
 * Created by nishant on 02/02/20.
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
