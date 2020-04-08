package com.nal.leetcode.arrays;

import java.util.*;

/**
 * Created by nishant on 01/03/20.
 * 621. Task Scheduler
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters
 * represent different tasks. Tasks could be done without original order. Each task could be done in one interval.
 * For each interval, CPU could finish one task or just be idle.
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n
 * intervals that CPU are doing different tasks or just be idle.
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * Example:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 */
public class TaskScheduler {

    public int leastInterval2(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return 0;
        int[] freqMap = new int[26];
        for (char c : tasks) {
            freqMap[c - 'A']++;
        }
        Arrays.sort(freqMap);
        int max = freqMap[25] - 1;
        int idle = max * n;
        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(freqMap[i], max);
        }
        return idle > 0 ? idle + tasks.length : tasks.length;
    }

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0)
            return 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : tasks) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.addAll(freqMap.values());
        int cycles = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    temp.add(maxHeap.poll());
                }
            }
            for (int val : temp) {
                if (--val > 0)
                    maxHeap.add(val);
            }
            cycles += maxHeap.isEmpty() ? temp.size() : n + 1;
        }
        return cycles;
    }
}
