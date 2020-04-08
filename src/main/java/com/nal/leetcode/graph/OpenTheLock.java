package com.nal.leetcode.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nishant on 21/03/20.
 * 752. Open the Lock
 * You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
 * Given a target representing the value of the wheels that will unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * Example 1:
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 */
public class OpenTheLock {

    public static void main(String[] args) {
        OpenTheLock openTheLock = new OpenTheLock();
        openTheLock.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0201");
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visitedSet = new HashSet<>();

        Queue<String> queue = new LinkedList<>();
        if(!deadendSet.contains("0000")) {
            queue.add("0000");
            visitedSet.add("0000");
        }
        int level = 0;
        while(!queue.isEmpty()) {
            for(int i = queue.size()- 1; i >= 0; i--) {
                String val = queue.poll();
                if(val.equals(target))
                    return level;
                for(int j = 0; j < 4; j++) {
                    String newValUp = turnWheelUp(val, j);
                    if(!visitedSet.contains(newValUp) && !deadendSet.contains(newValUp)) {
                        visitedSet.add(newValUp);
                        queue.offer(newValUp);
                    }
                    String newValDown = turnWheelDown(val, j);
                    if(!visitedSet.contains(newValDown) && !deadendSet.contains(newValDown)) {
                        visitedSet.add(newValDown);
                        queue.offer(newValDown);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private String turnWheelUp(String str, int index) {
        StringBuilder sb = new StringBuilder(str);
        char c = sb.charAt(index);
        sb.setCharAt(index, c == '9' ? '0' :(char)(c + 1));
        return sb.toString();
    }

    private String turnWheelDown(String str, int index) {
        StringBuilder sb = new StringBuilder(str);
        char c = sb.charAt(index);
        sb.setCharAt(index, c == '0' ? '9' : (char)(c - 1));
        return sb.toString();
    }
}
