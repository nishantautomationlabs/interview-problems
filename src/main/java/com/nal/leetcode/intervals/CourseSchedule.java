package com.nal.leetcode.intervals;

import java.util.*;

/**
 * Created by nishant on 27/02/20.
 * 207. Course Schedule
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 */
public class CourseSchedule {
    public static void main(String[] args) {
        CourseSchedule schedule = new CourseSchedule();
        System.out.println(schedule.canFinish(3, new int[][]{{0, 1}, {1, 2}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0)
            return true;

        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            adjList.get(pair[1]).add(pair[0]);
            indegree[pair[0]]++;
        }

        Queue<Integer> courses = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                courses.add(i);
            }
        }
        int courseCount = 0;
        while (!courses.isEmpty()) {
            int course = courses.poll();
            courseCount++;
            for (int val : adjList.get(course)) {
                if (--indegree[val] == 0) {
                    courses.add(val);
                }
            }
        }
        return courseCount == numCourses;
    }
}
