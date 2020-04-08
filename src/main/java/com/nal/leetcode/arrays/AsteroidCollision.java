package com.nal.leetcode.arrays;

import java.util.Stack;

/**
 * Created by nishant on 27/03/20.
 * 735. Asteroid Collision
 * We are given an array asteroids of integers representing asteroids in a row.
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * Example 1:
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0)
            return asteroids;

        Stack<Integer> stack = new Stack<>();
        for (int val : asteroids) {
            if (stack.isEmpty() || stack.peek() < 0) {
                stack.push(val);
            } else {
                if (val > 0) {
                    stack.push(val);
                } else {
                    int absVal = Math.abs(val);
                    while (!stack.isEmpty() && stack.peek() > 0 && absVal > stack.peek()) {
                        stack.pop();
                    }
                    if (stack.isEmpty()) {
                        stack.push(val);
                    } else if (stack.peek() < 0) {
                        stack.push(val);
                    } else if (absVal == stack.peek()) {
                        stack.pop();
                    }
                }
            }
        }
        int[] result = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[index--] = stack.pop();
        }
        return result;
    }
}
