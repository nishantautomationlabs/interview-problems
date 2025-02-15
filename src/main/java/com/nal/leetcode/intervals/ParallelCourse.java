package com.nal.leetcode.intervals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by nishant on 28/02/20.
 * There are N courses, labelled from 1 to N.
 * We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y: course X has to be studied before course Y.
 * In one semester you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.
 * Return the minimum number of semesters needed to study all courses. If there is no way to study all the courses, return -1.
 */
public class ParallelCourse {

    public static void main(String[] args) {
        int[][] courses = {{1, 3}, {2, 3}, {3, 4}, {5, 6}};
        ParallelCourse course = new ParallelCourse();
        System.out.println(course.minimumSemester(6, courses));
    }

    public int minimumSemester(int N, int[][] courses) {
        if (courses == null || courses.length == 0)
            return -1;


        int[] indegree = new int[N];
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] course : courses) {
            indegree[course[1] - 1]++;
            lists.get(course[0] - 1).add(course[1] - 1);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        int result = 0;
        int count = 0;
        while (!queue.isEmpty()) {
            result++;
            for (int i = queue.size() - 1; i >= 0; i--) {
                int val = queue.poll();
                count++;
                for(int neighbor : lists.get(val)) {
                    if(--indegree[neighbor] == 0){
                        queue.add(neighbor);
                    }
                }
            }
        }
        if(count != N)
            return -1;
        return result;
    }
}
