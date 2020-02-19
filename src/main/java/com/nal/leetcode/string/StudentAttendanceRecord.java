package com.nal.leetcode.string;

/**
 * Created by nishant on 10/02/20.
 * 551. Student Attendance Record I
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
 * Example 1:
 * Input: "PPALLP"
 * Output: True
 */
public class StudentAttendanceRecord {
    public boolean checkRecord(String s) {
        if (s == null)
            return false;

        int aCount = 0, lCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'A' && ++aCount > 1) {
                return false;
            } else if (c == 'L') {
                if (++lCount > 2)
                    return false;
            } else
                lCount = 0;
        }
        return true;
    }
}
