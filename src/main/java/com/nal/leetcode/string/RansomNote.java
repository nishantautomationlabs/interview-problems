package com.nal.leetcode.string;

import com.nal.leetcode.Solution;

/**
 * Created by nishant on 24/02/20.
 * 383. Ransom Note
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 */
public class RansomNote {

    public static void main(String[] args) {
        String magazine = "this is a magazine";
        String note = "zhiaaaa";
        RansomNote sol = new RansomNote();
        boolean result = sol.canConstruct(note, magazine);
        System.out.println("Note can be constructed: " + result);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null || ransomNote == null || ransomNote.length() > magazine.length()) {
            return false;
        }
        int[] freqMap = new int[256];
        for (char c : magazine.toCharArray()) {
            ++freqMap[c];
        }

        for (char c : ransomNote.toCharArray()) {
            if (--freqMap[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
