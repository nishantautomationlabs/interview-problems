package com.nal.lintcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by nishant on 10/02/20.
 * 920. Meeting Rooms
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: false
 * Explanation:
 * (0,30), (5,10) and (0,30),(15,20) will conflict
 */
public class MeetingRooms {

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1)
            return true;

//        Collections.sort(intervals, (a,b) -> a.start - b.start);
        Collections.sort(intervals, Comparator.comparingInt(s -> s.start));

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end)
                return false;
        }
        return true;
    }
}
