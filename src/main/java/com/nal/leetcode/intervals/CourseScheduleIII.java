package com.nal.leetcode.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by nishant on 28/02/20.
 * 630. Course Schedule III
 * There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and closed on
 * dth day. A course should be taken continuously for t days and must be finished before or on the dth day.
 * You will start at the 1st day.
 * Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.
 * Example:
 * Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
 * Output: 3
 */
public class CourseScheduleIII {

    public int scheduleCourse(int[][] courses) {
        if(courses == null || courses.length == 0 || courses[0].length == 0)
            return 0;

        Arrays.sort(courses, Comparator.comparingInt(s -> s[1]));   //sort by finish date

        //Max heap for duration of the course
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        queue.add(courses[0][0]);
        int days = courses[0][0];
        for(int i = 1; i < courses.length; i++) {
            if(days + courses[i][0] <= courses[i][1]) {
                days = days + courses[i][0];
                queue.offer(courses[i][0]);
            }
            else {
                days = days + courses[i][0];
                queue.offer(courses[i][0]);
                int t = queue.poll();
                days = days - t;
            }
        }
        return queue.size();
    }
}
