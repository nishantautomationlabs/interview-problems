package com.nal.leetcode.intervals;

import java.util.*;

/**
 * Created by nishant on 28/02/20.
 * 210. Course Schedule II
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
