package com.nal.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 03/02/20.
 * 93. Restore IP Addresses
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * A valid IP address consists of exactly four integers (each integer is between 0 and 255) separated by single points.
 * Example:
 *
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 4 || s.length() > 12)
            return result;

        for (int i = 1; i < s.length() && i < 4; i++) {
            String first = s.substring(0, i);
            if (!isValidPart(first))
                continue;
            for (int j = 1; j + i < s.length() && j < 4; j++) {
                String second = s.substring(i, i + j);
                if (!isValidPart(second))
                    continue;
                for (int k = 1; i + j + k < s.length() && k < 4; k++) {
                    String third = s.substring(i + j, i + j + k);
                    String fourth = s.substring(i + j + k);
                    if (!isValidPart(third) || !isValidPart(fourth))
                        continue;
                    result.add(first + "." + second + "." + third + "." + fourth);
                }
            }
        }
        return result;
    }

    private boolean isValidPart(String part) {
        if (part == null || part.length() == 0 || part.length() > 3)
            return false;
        if (part.startsWith("0") && part.length() > 1)
            return false;
        return Integer.parseInt(part) <= 255;
    }
}
