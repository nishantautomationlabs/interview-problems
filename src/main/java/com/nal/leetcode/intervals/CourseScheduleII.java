package com.nal.leetcode.intervals;

import java.util.*;

/**
 * Created by nishant on 28/02/20.
 * 210. Course Schedule II
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null)
            return new int[0];

        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            indegree[pair[0]]++;
            adjList.get(pair[1]).add(pair[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        int[] result = new int[numCourses];

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result[count] = node;
            count++;
            for (int neighbor : adjList.get(node)) {
                if (--indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        if (count == numCourses)
            return result;
        return new int[0];
    }
}
