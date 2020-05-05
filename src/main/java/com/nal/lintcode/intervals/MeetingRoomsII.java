package com.nal.lintcode.intervals;

import java.util.*;

/**
 * Created by nishant on 10/02/20.
 * 919. Meeting Rooms
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * Input: intervals = [(0,30),(5,10),(15,20)]
 * Output: 2
 * Explanation:
 * We need two meeting rooms
 * room1: (0,30)
 * room2: (5,10),(15,20)
 */
public class MeetingRoomsII {

    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0)
            return 0;

        Collections.sort(intervals, Comparator.comparingInt(s -> s.start));
        Queue<Integer> meetingRooms = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (!meetingRooms.isEmpty() && meetingRooms.peek() <= interval.start) {
                meetingRooms.poll();
            }
            meetingRooms.offer(interval.end);
        }
        return meetingRooms.size();
    }
}
