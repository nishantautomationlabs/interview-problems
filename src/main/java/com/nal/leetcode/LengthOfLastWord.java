package com.nal.leetcode;

/**
 * Created by nishant on 31/01/20.
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int length = 0;
        s = s.trim();
        if(s == null || s.length() == 0)
            return length;
        for(int i = s.length()-1; i >= 0; i--)
        {
            if(s.charAt(i) == ' ')
                return length;
            length++;
        }
        return length;
    }
}
