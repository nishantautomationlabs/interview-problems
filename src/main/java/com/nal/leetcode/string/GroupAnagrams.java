package com.nal.leetcode.string;

import java.util.*;

/**
 * Created by nishant on 10/02/20.
 * 49. Group Anagrams
 * Given an array of strings, group anagrams together.
 */
public class GroupAnagrams {

    //Time Complexity O(NK) - N length of strs and K is the length of the longest word
    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs == null || strs.length == 0)
            return Collections.EMPTY_LIST;

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String key = getKey(str);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    private String getKey(String str) {
        int[] freq = new int[26];
        for (char c : str.toCharArray())
            ++freq[c - 'a'];
        StringBuilder sb = new StringBuilder();
        for (int i : freq)
            sb.append(i);
        return sb.toString();
    }

    //Time Complexity O(NKLogK) - N length of strs and K is the length of the longest word
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0)
            return Collections.EMPTY_LIST;

        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
