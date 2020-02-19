package com.nal.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nishant on 09/02/20.
 * 763. Partition Labels
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<>();
        if (S == null || S.length() == 0)
            return result;

        int[] lastIndex = new int[26];
        for (int i = 0; i < S.length(); i++)
            lastIndex[S.charAt(i) - 'a'] = i;
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastIndex[S.charAt(i) - 'a']);
            if (i == end) {
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        return result;
    }
}
